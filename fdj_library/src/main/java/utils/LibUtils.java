package utils;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by ZhijunHong on 2017/11/30.
 */

public class LibUtils {
    private static final String DEBUG_TAG = "fdj";

    public static void myLog(String msg) {
        myLog(DEBUG_TAG, msg);
    }

    public static void myLog(String title, String msg) {
        if (msg == null) {
            log(title, "msg is null");
            return;
        }
        if (msg.length() > 4000) {
            //超过长度，分段
            for (int i = 0; i < msg.length(); i += 4000) {
                if (i + 4000 < msg.length()) {
                    log(title, msg.substring(i, i + 4000));
                } else {
                    log(title, msg.substring(i, msg.length()));
                }
            }
        } else {
            log(title, msg);
        }
    }


    public static void log(String title, String msg) {
        if (isMainThread()) {
            Log.e(title, "---- main ---- " + msg);
        } else {
            Log.e(title, msg);
        }
    }

    /**
     * 判断是否是主线程
     *
     * @return
     */
    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
