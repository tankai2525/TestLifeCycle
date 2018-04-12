package tan.kai.testlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

/**
 * 静态加载fragment
 */
public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate-开始");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        /*
        生命周期顺序如下
        1 activity onCreate 开始
        2 fragment 构造方法
        3 fragment onInflate() 当fragment作为布局视图时，在onAttach之前调用
        4 fragment onAttach() 当fragment第一次附加到activity时候调用
        5 activity onAttachFragment() 在fragmet onAttach调用后 fragment onCreate之前调用执行
        6 fragment onCreate() 在onAttach之后onCreateView之前调用
        7 fragment onCreateView() 在onCreate之后onViewCreated之前调用
        8 fragment onViewCreated 在onCreateView之后立马调用
        9 activity onContentChanged
        10 activity onCreate 结束
         */
        log("onCreate-结束");
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        log("onAttachFragment");
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        log("onContentChanged");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        log("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        log("onActivityResult");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        log("onRestoreInstanceState");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        log("onPostCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        log("onPostResume");
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        log("onAttachedToWindow");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        log("onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        log("onPrepareOptionsMenu");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        log("onSaveInstanceState");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    private void log(String text) {
        Log.e("lifecycle", "---activity1:" + text);
    }
}
