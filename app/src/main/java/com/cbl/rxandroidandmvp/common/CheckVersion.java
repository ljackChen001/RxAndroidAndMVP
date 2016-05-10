package com.cbl.rxandroidandmvp.common;

/**
 * Created by BaoLin Chen on 2016/5/3.
 * e-mail 505951628@qq.com
 */
public class CheckVersion {
//    private static String TAG = CheckVersion.class.getSimpleName();
//    public static void checkVersion(final Context context, final View view) {
//        RetrofitSingleton.getApiService(context)
//                .mVersionAPI(Setting.API_TOKEN)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(versionAPI -> {
//                    String firVersionName = versionAPI.versionShort;
//                    String currentVersionName = Util.getVersion(context);
//                    if (currentVersionName.compareTo(firVersionName) < 0) {
//                        showUpdateDialog(versionAPI, context);
//                    } else {
//                        Snackbar.make(view, "已经是最新版本(⌐■_■)", Snackbar.LENGTH_SHORT).show();
//                    }
//                });
//    }
//    public static void showUpdateDialog(final VersionAPI versionAPI, final Context context) {
//        String title = "发现新版" + versionAPI.name + "版本号：" + versionAPI.versionShort;
//
//        new AlertDialog.Builder(context).setTitle(title)
//                .setMessage(versionAPI.changelog)
//                .setPositiveButton("下载", (dialog, which) -> {
//                    Uri uri = Uri.parse(versionAPI.updateUrl);   //指定网址
//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);           //指定Action
//                    intent.setData(uri);                            //设置Uri
//                    context.startActivity(intent);        //启动Activity
//                })
//                .show();
//    }
}
