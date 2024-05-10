package com.example.vhr.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vhr.R;
import com.example.vhr.fragment.Publish.PublishFragment;
import com.example.vhr.fragment.myinfo.MyInfoFragment;
import com.example.vhr.http.AjaxResult;
import com.example.vhr.http.HttpUtils;
import com.example.vhr.http.OnResponseListener;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class JobInfoChangeActivity extends AppCompatActivity {
    private Button cancel,finish;
    private AjaxResult result;
    private EditText name,idNumber,email,tel,jobName,beginContract,endContract,base;
    private PopupWindow popupWindow;
    private int id = 0;
    private Integer job_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info_change);

        findViewId();
        ShowData();
    }

    private void findViewId() {
        name = findViewById(R.id.name);
        idNumber = findViewById(R.id.idNumber);
        email = findViewById(R.id.email);
        tel = findViewById(R.id.tel);
        jobName = findViewById(R.id.jobName);
        beginContract = findViewById(R.id.begincontract);
        endContract = findViewById(R.id.endcontract);
        base = findViewById(R.id.base);

        cancel=(Button) findViewById(R.id.job_cancel);
        finish=(Button) findViewById(R.id.job_finish);

        cancel.setOnClickListener(new OnClick());
        finish.setOnClickListener(new OnClick());
    }

    private void ShowData() {
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        name.setText(bundle.getString("name"));
        idNumber.setText(bundle.getString("idNumber"));
        email.setText(bundle.getString("email"));
        tel.setText(bundle.getString("tel"));
        jobName.setText(bundle.getString("jobName"));
        beginContract.setText(bundle.getString("beginContract"));
        endContract.setText(bundle.getString("endContract"));
        base.setText(bundle.getString("base"));
        job_id=bundle.getInt("job_id");
    }
    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent=new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            switch (view.getId()){
                case R.id.job_cancel:
                    JobInfoChangeActivity.this.finish();
                    break;
                case R.id.job_finish:
                    Map<String,String> map =new HashMap<>();
                    String name1=name.getText().toString().trim();
                    String idNumber1=idNumber.getText().toString().trim();
                    String email1=email.getText().toString().trim();
                    String tel1=tel.getText().toString().trim();
                    String jobName1=jobName.getText().toString().trim();
                    String beginContract1=beginContract.getText().toString().trim();
                    String endContract1=endContract.getText().toString().trim();
                    String base1=base.getText().toString().trim();
                    map.put("name",name1);
                    map.put("idNumber",idNumber1);
                    map.put("email",email1);
                    map.put("tel",tel1);
                    map.put("jobName",jobName1);
                    map.put("beginContract",beginContract1);
                    map.put("endContract",endContract1);
                    map.put("base",base1);
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpUtils.postRequestJson("http://124.221.111.224:8081/positionRequire", map, "utf-8", new OnResponseListener() {
                                //                HttpUtils.postRequest("http://192.168.43.143:8081/doLogin", map, "utf-8", new OnResponseListener() {
                                @Override
                                public void onSuccess(String response) {
                                    System.out.println(response);
                                    result = new Gson().fromJson(response, AjaxResult.class);
                                    System.out.println(result.getObj());
                                    System.out.println("bbbbb");
                                }

                                @Override
                                public void onError(String error) {
                                    System.out.println("请求失败：" + error);
                                }
                            });
                        }
                    });

                    thread.start();
                    try {
                        if (result == null) {
//                    Log.e("message", "错误");
                        }
                        while (result == null) {
                            //等待线程执行完毕
                            Thread.sleep(100);
                        }
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (result.getStatus() == 200) {
                        deleteData();
                        Toast.makeText(JobInfoChangeActivity.this, "修改信息成功", Toast.LENGTH_SHORT).show();
                        JobInfoChangeActivity.this.finish();

                    }else{
                        Toast.makeText(JobInfoChangeActivity.this, "修改信息失败", Toast.LENGTH_SHORT).show();

                    }
                    break;
            }
        }
    }

    private void deleteData(){

        Map<String, String> map1 = new HashMap<>();
        //map1.put("id",job_id);
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                HttpUtils.deleteRequest("http://124.221.111.224:8081/positionRequire/" + job_id, map1, "utf-8", new OnResponseListener() {
                    @Override
                    public void onSuccess(String response) {
                        result = new Gson().fromJson(response, AjaxResult.class);
                    }

                    @Override
                    public void onError(String error) {
                        System.out.println("请求失败：" + error);
                    }
                });
            }
        });

        thread.start();

        try {
            while (result == null) {
                //等待线程执行完毕
                Thread.sleep(100);
            }
            if (result == null) {
                Log.e("message", "错误");
            }
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        if (result.getStatus() == 200) {
//            Toast.makeText(ChangePublishActivity.this, "删除信息成功", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(ChangePublishActivity.this, "删除信息失败", Toast.LENGTH_SHORT).show();
//        }
    }


}
