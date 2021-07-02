package com.codingcrew.audify.components;

import android.graphics.Color;
import android.text.TextUtils;

import com.codingcrew.audify.R;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.Row;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Image;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaJustify;


@LayoutSpec
public class CardElementSpec {

    @OnCreateLayout
    static Component onCreateLayout(
            ComponentContext c,
            @Prop String name,
            @Prop String artist) {

        Component titleComp = Text.create(c)
                .text(name)
                .textSizeDip(20)
                .maxLines(3)
                .marginDip(YogaEdge.TOP, 4)
                .marginDip(YogaEdge.START, 8)
                .marginDip(YogaEdge.END, 8)
                .ellipsize(TextUtils.TruncateAt.END)
                .textColor(Color.BLACK)
                .build();

        Component artistComp = Text.create(c)
                .text(artist)
                .textSizeDip(16)
                .marginDip(YogaEdge.TOP, 4)
                .marginDip(YogaEdge.START, 8)
                .marginDip(YogaEdge.END, 8)
                .marginDip(YogaEdge.BOTTOM, 4)
                .build();

        return Row.create(c)
                .justifyContent(YogaJustify.SPACE_BETWEEN)
                .child(Row.create(c)
                        .child(getIcon(c, 1))
                        .child(Column.create(c)
                                .child(titleComp)
                                .child(artistComp)
                                .build())

                        .build())
                .child(Row.create(c)
                        .child(getIcon(c, 2))
                        .child(Text.create(c)
                                .text("10")
                                .marginDip(YogaEdge.END, 8)
                                .alignSelf(YogaAlign.CENTER)
                                .build())
                        .build())
                .build();

    }

    private static Component getIcon(ComponentContext c, int type) {
        if (type == 1) {
            return Image.create(c)
                    .drawableRes(R.drawable.ic_play_circle)
                    .marginDip(YogaEdge.START, 8)
                    .scale(1.3f)
                    .build();
        } else {
            return Image.create(c)
                    .drawableRes(R.drawable.ic_play)
                    .marginDip(YogaEdge.END, 8)
                    .build();
        }
    }
}