package com.codingcrew.audify.components;

import android.graphics.Color;

import com.codingcrew.audify.model.Audio;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.RenderEvent;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.RenderInfo;

import java.util.List;

@GroupSectionSpec
public class ListSectionSpec {

    private static final String TAG = "ListSectionSpec";

    @OnCreateChildren
    static Children onCreateChildren(
            final SectionContext c,
            @Prop List<Audio> audio
    ) {
        Children.Builder builder = Children.create();
        builder.child(DataDiffSection.<Audio>create(c)
                .data(audio)
                .renderEventHandler(ListSection.onRender(c)
                ));
        return builder.build();
    }

    @OnEvent(RenderEvent.class)
    static RenderInfo onRender(
            SectionContext c,
            @FromEvent Audio model
    ) {
        return ComponentRenderInfo.create()
                .component(
                        Card.create(c)
                                .content(CardElement.create(c)
                                        .artist(model.getArtist())
                                        .name(model.getName()))
                                .elevationDip(6)
                                .build()
                ).build();
    }
}