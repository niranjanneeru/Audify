package com.codingcrew.audify.components;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateInitialState;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.fresco.FrescoImage;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
class CategoryCardElementSpec {

    @OnCreateInitialState
    static void onCreateInitialState(ComponentContext c
    ) {
        // TODO: remove this method if not needed. Set an initial value for a state https://fblitho.com/docs/state
    }

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop String genre,
                                    @Prop String imageRes
    ) {
        // TODO: describe your UI with existing components https://fblitho.com/docs/layout-specs
        return Column.create(c)
                .child(getImage(c, imageRes))
                .child(Text.create(c)
                        .text(genre)
                        .build())
                .marginDip(YogaEdge.ALL,7)
                .build();
    }

    static Component getImage(ComponentContext c, String imageRes) {
        return FrescoImage.create(c)
                .controller(Fresco.newDraweeControllerBuilder()
                        .setUri(imageRes)
                        .build())
                .marginDip(YogaEdge.ALL, 4)
                .build();
    }
}