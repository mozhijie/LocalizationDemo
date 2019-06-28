package com.mzj.localizationdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @BindView(R.id.btn_auto)
    Button btnAuto;
    @BindView(R.id.btn_traditional)
    Button btnTraditional;
    @BindView(R.id.btn_simplified)
    Button btnSimplified;
    @BindView(R.id.btn_en)
    Button btnEn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        getSupportActionBar().setTitle(R.string.app_name);
    }

    private void selectLanguage(int select) {
        LocalManageUtil.saveSelectLanguage(this, select);
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @OnClick({R.id.btn_auto, R.id.btn_traditional, R.id.btn_simplified, R.id.btn_en})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_auto:
                selectLanguage(0);
                break;
            case R.id.btn_simplified:
                selectLanguage(1);
                break;
            case R.id.btn_traditional:
                selectLanguage(2);
                break;
            case R.id.btn_en:
                selectLanguage(3);
                break;
        }
    }

}
