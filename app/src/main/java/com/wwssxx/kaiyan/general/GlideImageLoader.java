package com.wwssxx.kaiyan.general;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.wwssxx.kaiyan.R;
import com.youth.banner.loader.ImageLoader;

public class GlideImageLoader extends ImageLoader {

    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //具体方法内容自己去选择，次方法是为了减少banner过多的依赖第三方包，所以将这个权限开放给使用者去选择
        Glide.with(context.getApplicationContext())
                .load(path)
                .crossFade()
                .into(imageView);
    }

    public static void displayImageByUrl(Context context, String url, ImageView view) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .crossFade()
                .placeholder(R.drawable.app_image_loading)
                .error(R.drawable.app_image_loading)
                .into(view);
    }

}
