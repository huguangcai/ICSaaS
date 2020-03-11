package com.ysxsoft.icsaas.ui.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.ysxsoft.icsaas.MainActivity;
import com.ysxsoft.icsaas.R;
import com.ysxsoft.icsaas.common_base.base.BaseActivity;
import com.ysxsoft.icsaas.common_base.utils.JsonUtils;
import com.ysxsoft.icsaas.common_base.utils.SpUtils;
import com.ysxsoft.icsaas.config.Api;
import com.ysxsoft.icsaas.config.ResponsesCode;
import com.ysxsoft.icsaas.config.Urls;
import com.ysxsoft.icsaas.modle.LoginBean;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import okhttp3.RequestBody;

/**
 * Create By 胡
 * on 2020/3/3 0003
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.etUser)
    EditText etUser;
    @BindView(R.id.icon_close)
    ImageView icon_close;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.Login)
    TextView Login;
    @BindView(R.id.tvForgetPwd)
    TextView tvForgetPwd;

    @Override
    protected void setListener() {
        icon_close.setOnClickListener(this);
        Login.setOnClickListener(this);
        tvForgetPwd.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        etUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                icon_close.setVisibility(TextUtils.isEmpty(s) ? View.GONE : View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login_layout;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_close:
                etUser.setText("");
                break;
            case R.id.Login:
                if (TextUtils.isEmpty(etUser.getText().toString().trim())) {
                    showToast("用户名不能为空");
                    return;
                }
                if (TextUtils.isEmpty(etPwd.getText().toString().trim())) {
                    showToast("密码不能为空");
                    return;
                }
                LoginData();
                break;
            case R.id.tvForgetPwd:
                showToast("跳转到忘记密码");
                break;
        }
    }

    /**
     * 登录
     */
    private void LoginData() {
        JSONObject json = new JSONObject();
        try {
            json.put("email", etUser.getText().toString().trim());
            json.put("password",etPwd.getText().toString().trim());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body = Api.BodyJson(json.toString());
        OkGo.<String>post(Urls.LOGIN_IN).tag(this)
                .headers("platform", "APP")
                .upRequestBody(body)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                        LoginBean bean = JsonUtils.parseByGson(response.body(), LoginBean.class);
                        if (bean != null) {
                            if (ResponsesCode.Sucess.equals(bean.getCode())) {
                                SpUtils.saveSp(mContext, "token", bean.getInfo().getToken());
                                toActivity(MainActivity.class);
                                finish();
                                Log.e("tag", "token===" + bean.getInfo().getToken());
                            } else {
                                showToast(bean.getMessage());
                            }
                        }
                    }
                });
    }
}
