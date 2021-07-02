package com.codingcrew.audify.components;

import com.codingcrew.audify.model.Category;
import com.facebook.litho.annotations.FromEvent;
import com.facebook.litho.annotations.OnEvent;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.DataDiffSection;
import com.facebook.litho.sections.common.OnCheckIsSameContentEvent;
import com.facebook.litho.sections.common.OnCheckIsSameItemEvent;
import com.facebook.litho.sections.common.RenderEvent;
import com.facebook.litho.widget.Card;
import com.facebook.litho.widget.ComponentRenderInfo;
import com.facebook.litho.widget.RenderInfo;

import java.util.List;

@GroupSectionSpec
class CategoryListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(
            SectionContext c,
            @Prop List<Category> categories) {
        // TODO: structure your data in a hierarchy of Sections.
        return Children.create()
                .child(
                        DataDiffSection.<Category>create(c)
                                .data(categories)
                                .renderEventHandler(CategoryListSection.onRender(c))
                                .onCheckIsSameItemEventHandler(CategoryListSection.onCheckIsSameItem(c))
                                .onCheckIsSameContentEventHandler(CategoryListSection.onCheckIsSameContent(c))
                )
                .build();
    }

    @OnEvent(RenderEvent.class)
    static RenderInfo onRender(
            SectionContext c,
            @FromEvent int index,
            @FromEvent Category model) {
        // TODO: remove if renderEventHandler is not needed.
        return ComponentRenderInfo.create()
                .component(Card.create(c)
                        .content(CategoryCardElement.create(c)
                                .genre(model.getTitle())
                                .imageRes(model.getImage())
                                .build()))
                .build();
    }

    @OnEvent(OnCheckIsSameItemEvent.class)
    static boolean onCheckIsSameItem(
            SectionContext c,
            @FromEvent String previousItem,
            @FromEvent String nextItem) {
        // TODO: remove if onCheckIsSameItemEventHandler is not needed. Check whether two items represent the same piece of data.
        return previousItem.equals(nextItem);
    }

    @OnEvent(OnCheckIsSameContentEvent.class)
    static boolean onCheckIsSameContent(
            SectionContext c,
            @FromEvent String previousItem,
            @FromEvent String nextItem) {
        // TODO: remove if onCheckIsSameContentEventHandler is not needed. Check whether same piece of data have exactly same content.
        return previousItem.equals(nextItem);
    }
}