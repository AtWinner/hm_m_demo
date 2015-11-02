package com.hemaapp.demo.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import xtom.frame.util.XtomToastUtil;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.example.hm_m_demo.R;
import com.hemaapp.demo.MyActivity;
import com.hemaapp.demo.MyApplication;
import com.hemaapp.demo.MyHttpInformation;
import com.hemaapp.demo.MyLocation;
import com.hemaapp.demo.adapter.LocationAdapter;
import com.hemaapp.demo.db.VisitCitysDBHelper;
import com.hemaapp.demo.model.DistrictInfor;
import com.hemaapp.demo.util.CharacterParser;
import com.hemaapp.demo.util.PinyinComparator;
import com.hemaapp.demo.view.ClearEditText;
import com.hemaapp.demo.view.LetterListView;
import com.hemaapp.demo.view.LetterListView.OnTouchingLetterChangedListener;
import com.hemaapp.hm_FrameWork.HemaNetTask;
import com.hemaapp.hm_FrameWork.result.HemaBaseResult;
import com.hemaapp.hm_FrameWork.result.HemaPageArrayResult;

/**
 * ѡ�����
 * */
public class CityActivity extends MyActivity implements AMapLocationListener{

	private TextView titleText; //������������
	private ImageView titleLeft; //���
	private TextView titleRight; //�Ҽ�

	private ClearEditText etSearch; //�Զ���༭��
	private ListView mCityList; //չʾ���е�listview
	private LetterListView letterList; //�Ҳ���ĸ�����б�
	private TextView overlay; //�����ĸ�����б�󣬳��ֵĶ�����

	private HashMap<String, Integer> alphaIndexer;// ��Ŵ��ڵĺ���ƴ������ĸ����֮��Ӧ���б�λ��
	private Handler handler;
	private OverlayThread overlayThread;
	private WindowManager windowManager;
	
	/**
	 * ����ת����ƴ������
	 */
	private CharacterParser characterParser;
	/**
	 * ����ƴ��������ListView�����������
	 */
	private PinyinComparator pinyinComparator;
	private LoacationReceiver loacationReceiver;

	private String locationCity;
	private ArrayList<DistrictInfor> allDistricts;
	private ArrayList<DistrictInfor> visitDistricts;
	private ArrayList<DistrictInfor> filterDateList;
	private LocationAdapter mLocationAdapter;
	private LocationManagerProxy mLocationManagerProxy;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_city);
		super.onCreate(savedInstanceState);
		handler = new Handler();
		overlayThread = new OverlayThread();
		initOverlay();
		initViews();
//		getLocationCity();

		// ��ʼ����λ��ֻ�������綨λ
		mLocationManagerProxy = LocationManagerProxy.getInstance(this);
		mLocationManagerProxy.setGpsEnable(true);
		// �˷���Ϊÿ���̶�ʱ��ᷢ��һ�ζ�λ����Ϊ�˼��ٵ������Ļ������������ģ�
		// ע�����ú��ʵĶ�λʱ��ļ������С���֧��Ϊ2000ms���������ں���ʱ�����removeUpdates()������ȡ����λ����
		// �ڶ�λ�������ں��ʵ��������ڵ���destroy()����
		// ����������ʱ��Ϊ-1����λֻ��һ��,
		// �ڵ��ζ�λ����£���λ���۳ɹ���񣬶��������removeUpdates()�����Ƴ����󣬶�λsdk�ڲ����Ƴ�
		mLocationManagerProxy.requestLocationData(
				LocationProviderProxy.AMapNetwork, 60 * 1000, 15, this);
	}

	// ��ȡ��λ����
//	private void getLocationCity() {
//		AMapLocation location = MyLocation.getInstance().getaMapLocation();
//		
//	}

	@Override
	protected void onDestroy() {
		windowManager.removeView(overlay);
		if (loacationReceiver != null)
			unregisterReceiver(loacationReceiver);
		// �Ƴ���λ����
		mLocationManagerProxy.removeUpdates(this);
		// ���ٶ�λ
		mLocationManagerProxy.destroy();
		super.onDestroy();
	}

	private void initViews() {
		// ʵ��������תƴ����
		characterParser = CharacterParser.getInstance();
		pinyinComparator = new PinyinComparator();
		// �������������ֵ�ĸı�����������
		etSearch.addTextChangedListener(new TextChageListener());
	}

	/**
	 * ����������е�ֵ���������ݲ�����ListView
	 * 
	 * @param filterStr
	 */
	private void filterData(String filterStr) {
		filterDateList = new ArrayList<DistrictInfor>();

		if (TextUtils.isEmpty(filterStr)) {
			filterDateList = allDistricts;
		} else {
			filterDateList.clear();
			for (DistrictInfor district : allDistricts) {
				String name = district.getName();
				if (name.indexOf(filterStr.toString()) != -1
						|| characterParser.getSelling(name).startsWith(
								filterStr.toString().toLowerCase(
										Locale.getDefault()))) {
					filterDateList.add(district);
				}
			}
		}
		boolean isshow = etSearch.isVisibile();
		mLocationAdapter.setShow(!isshow);
		// ����a-z��������
		Collections.sort(filterDateList, pinyinComparator);
		mLocationAdapter.updateListView(filterDateList);
	}

	// ��ʼ������ƴ������ĸ������ʾ��
	@SuppressLint("InflateParams")
	private void initOverlay() {
		LayoutInflater inflater = LayoutInflater.from(this);
		overlay = (TextView) inflater.inflate(R.layout.overlay, null);
		overlay.setVisibility(View.INVISIBLE);
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_APPLICATION,
				WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
						| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
				PixelFormat.TRANSLUCENT);
		windowManager = (WindowManager) this
				.getSystemService(Context.WINDOW_SERVICE);
		windowManager.addView(overlay, lp);
	}

	private void districtList() {
		getNetWorker().districtList("-1");
	}

	@Override
	protected void callBeforeDataBack(HemaNetTask netTask) {
		MyHttpInformation information = (MyHttpInformation) netTask
				.getHttpInformation();
		switch (information) {
		case DISTRICT_LIST:
			showProgressDialog("���ڻ�ȡ�����б�");
			break;
		default:
			break;
		}
	}

	@Override
	protected void callAfterDataBack(HemaNetTask netTask) {
		MyHttpInformation information = (MyHttpInformation) netTask
				.getHttpInformation();
		switch (information) {
		case DISTRICT_LIST:
			cancelProgressDialog();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void callBackForServerSuccess(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		MyHttpInformation information = (MyHttpInformation) netTask
				.getHttpInformation();
		switch (information) {
		case DISTRICT_LIST:
			HemaPageArrayResult<DistrictInfor> dResult = (HemaPageArrayResult<DistrictInfor>) baseResult;
			allDistricts = dResult.getObjects();

			mLocationAdapter.setLastCties(visitDistricts);
			mLocationAdapter.setLocCity(locationCity);

			Collections.sort(allDistricts, pinyinComparator);
			mLocationAdapter.setList(allDistricts);
			setAdapter(allDistricts);
			mLocationAdapter.notifyDataSetChanged();
			break;
		default:
			break;
		}
	}

	/**
	 * ΪListView����������
	 * 
	 * @param list
	 */
	private void setAdapter(List<DistrictInfor> list) {
		if (list != null) {
			mCityList.setAdapter(mLocationAdapter);
			alphaIndexer = mLocationAdapter.getAlphaIndexer();
		}
	}

	@Override
	protected void callBackForServerFailed(HemaNetTask netTask,
			HemaBaseResult baseResult) {
		MyHttpInformation information = (MyHttpInformation) netTask
				.getHttpInformation();
		switch (information) {
		case DISTRICT_LIST:
			showTextDialog(baseResult.getMsg());
			break;
		default:
			break;
		}
	}

	@Override
	protected void callBackForGetDataFailed(HemaNetTask netTask, int failedType) {
		MyHttpInformation information = (MyHttpInformation) netTask
				.getHttpInformation();
		switch (information) {
		case DISTRICT_LIST:
			break;
		default:
			break;
		}
	}

	@Override
	protected void findView() {
		titleText = (TextView) findViewById(R.id.txtTitle);
		titleLeft = (ImageView) findViewById(R.id.imageQuitActivity);
		titleRight = (TextView) findViewById(R.id.txtNext);

		etSearch = (ClearEditText) findViewById(R.id.etsearch);
		letterList = (LetterListView) findViewById(R.id.letterListView);
		mCityList = (ListView) findViewById(R.id.city_list);
		mLocationAdapter = new LocationAdapter(this, true);
	}

	@Override
	protected void getExras() {
	}

	@Override
	protected void setListener() {
		titleText.setText("��ǰ����");
		titleLeft.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		titleRight.setVisibility(View.GONE);
		letterList
				.setOnTouchingLetterChangedListener(new LetterListViewListener());
		mCityList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				DistrictInfor citysel = (DistrictInfor) view.getTag(R.id.TAG);
				itemclick(citysel);
			}
		});
	}

	/**
	 * �����б����¼�
	 * 
	 * 
	 */
	public void itemclick(DistrictInfor info) {
		if (info == null) {
			XtomToastUtil.showShortToast(mContext, "�ݲ�֧�ִ˳���");
			return;
		}
		String oldCityName = getCityName();
		saveCityName(info.getName());
		saveCityId(info.getId());
		insertVisitcity(info);
		if (isNull(oldCityName)) {
			Intent it = new Intent(mContext, MainActivity.class);
			startActivity(it);
			finish();
		} else {
			setResult(RESULT_OK);
			finish();
		}
	}

	private void insertVisitcity(DistrictInfor city) {
		VisitCitysDBHelper dbHelper = new VisitCitysDBHelper(mContext);
		dbHelper.reInsert(city);
	}

	private class LetterListViewListener implements
			OnTouchingLetterChangedListener {

		@SuppressLint("NewApi")
		@Override
		public void onTouchingLetterChanged(final String s) {
			if (alphaIndexer != null && alphaIndexer.get(s) != null) {
				final int position = alphaIndexer.get(s);
				log_w("=s=" + s);
				mCityList.setSelection(position + 2);
			} else if ("��".equals(s)) {
				mCityList.setSelection(0);
			}
			overlay.setText(s);
			overlay.setVisibility(View.VISIBLE);
			handler.removeCallbacks(overlayThread);
			// �ӳ�һ���ִ�У���overlayΪ���ɼ�
			handler.postDelayed(overlayThread, 1500);
		}
	}

	// ����overlay���ɼ�
	private class OverlayThread implements Runnable {

		@Override
		public void run() {
			overlay.setVisibility(View.GONE);
		}
	}

	private class VisitCityTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected void onPreExecute() {
			showProgressDialog("���Ժ�");
		}

		@Override
		protected Void doInBackground(Void... params) {
			VisitCitysDBHelper dbHelper = new VisitCitysDBHelper(mContext);
			visitDistricts = dbHelper.select();
			return null;
		}

		@Override
		protected void onPostExecute(Void v) {
			cancelProgressDialog();
			districtList();
		}
	}

	private class LoacationReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			MyApplication application = MyApplication.getInstance();
			String realAction = application.getPackageName() + ".location";
			String action = intent.getAction();
			if (realAction.equals(action)) {
				locationCity = MyLocation.getInstance().getaMapLocation()
						.getCity();
				mLocationAdapter.setLocCity(locationCity);
				if (mCityList.getAdapter() != null)
					mLocationAdapter.notifyDataSetChanged();
			}
		}
	}

	private class TextChageListener implements TextWatcher {
		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// ������������ֵΪ�գ�����Ϊԭ�����б�����Ϊ���������б�
			filterData(s.toString());
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
		}
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLocationChanged(AMapLocation location) {
		log_e(location.getCity());
		if (location != null)
			locationCity = location.getCity();
//		else
//			locationCity = "������";
		if (isNull(locationCity)) {
			MyApplication application = MyApplication.getInstance();
			String action = application.getPackageName() + ".location";
			IntentFilter mFilter = new IntentFilter(action);
			loacationReceiver = new LoacationReceiver();
			registerReceiver(loacationReceiver, mFilter);
		}
		new VisitCityTask().execute();
	}
	
}
