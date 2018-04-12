package tan.kai.testlifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;

/**
 * 动态加载fragment
 */
public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate-开始");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.contentFrame, new BlankFragment());
        ft.commit();

        log("onCreate-结束");
        /*
        动态加载fragment
        1 activity onCreate 开始
        2 activity onContentChanged
        3 fragment 构造方法
        4 activity onCreate 结束 【注意 这里fragment构造执行完，add和commit后不会立马调用fragment的onAttach, 还会继续执行完activity的onCreate方法】
        5 fragment onAttach 注意 是在activity onCreate方法彻底结束后在被调用
        6 activity onAttachFragment
        7 fragment onCreate
        8 fragment onCreateView
        9 fragment onViewCreated
        10 fragment onActivityCreated
         */
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
        Log.e("lifecycle", "---activity2:" + text);
    }
}
