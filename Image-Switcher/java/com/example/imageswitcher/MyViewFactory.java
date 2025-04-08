package com.example.imageswitcher;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

class MyViewFactory implements ViewSwitcher.ViewFactory {
    Context context;

    public MyViewFactory(Context c) {
        context = c;
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT));
        return imageView;
    }
}
