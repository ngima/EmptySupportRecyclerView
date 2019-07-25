package np.com.ngimasherpa.emptyviewsupportrecyclerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.util.AttributeSet;
import android.view.*;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class EmptyViewSupportRecyclerView extends FrameLayout {

    private View emptyView;
    private RecyclerView recyclerView;

    private RecyclerView.AdapterDataObserver emptyObserver = new RecyclerView.AdapterDataObserver() {

        @Override
        public void onChanged() {
            RecyclerView.Adapter<?> adapter = getAdapter();
            if (adapter != null && emptyView != null) {
                if (adapter.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }

        }
    };

    public EmptyViewSupportRecyclerView(@NonNull Context context) {
        super(context);
    }

    public EmptyViewSupportRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EmptyViewSupportRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray values = context.obtainStyledAttributes(attrs, R.styleable.EmptyViewSupportRecyclerView);

        emptyView = LayoutInflater.from(getContext()).inflate(values.getResourceId(R.styleable.EmptyViewSupportRecyclerView_empty_view_layout,
                R.layout.layout_default_empty_view), null, false);
        values.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        inflater.inflate(R.layout.recycler_view_empty_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        recyclerView = findViewById(R.id.recyclerView);
        addView(emptyView);
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return recyclerView.getCompatAccessibilityDelegate();
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate accessibilityDelegate) {
        recyclerView.setAccessibilityDelegateCompat(accessibilityDelegate);
    }

    public void setHasFixedSize(boolean hasFixedSize) {
        recyclerView.setHasFixedSize(hasFixedSize);
    }

    public boolean hasFixedSize() {
        return recyclerView.hasFixedSize();
    }

    public void setClipToPadding(boolean clipToPadding) {
        recyclerView.setClipToPadding(clipToPadding);
    }

    public boolean getClipToPadding() {
        return recyclerView.getClipToPadding();
    }

    public void setScrollingTouchSlop(int slopConstant) {
        recyclerView.setScrollingTouchSlop(slopConstant);

    }

    public void swapAdapter(@Nullable RecyclerView.Adapter adapter, boolean removeAndRecycleExistingViews) {
        recyclerView.swapAdapter(adapter, removeAndRecycleExistingViews);
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);

        if (adapter != null) {
            adapter.registerAdapterDataObserver(emptyObserver);
        }

        emptyObserver.onChanged();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return recyclerView.getAdapter();
    }

    public void setRecyclerListener(@Nullable RecyclerView.RecyclerListener listener) {
        recyclerView.setRecyclerListener(listener);
    }

    public int getBaseline() {
        return recyclerView.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(@NonNull RecyclerView.OnChildAttachStateChangeListener listener) {
        recyclerView.addOnChildAttachStateChangeListener(listener);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull RecyclerView.OnChildAttachStateChangeListener listener) {
        recyclerView.removeOnChildAttachStateChangeListener(listener);
    }

    public void clearOnChildAttachStateChangeListeners() {
        recyclerView.clearOnChildAttachStateChangeListeners();
    }

    public void setLayoutManager(@Nullable RecyclerView.LayoutManager layout) {
        recyclerView.setLayoutManager(layout);
    }

    public void setOnFlingListener(@Nullable RecyclerView.OnFlingListener onFlingListener) {
        recyclerView.setOnFlingListener(onFlingListener);
    }

    @Nullable
    public RecyclerView.OnFlingListener getOnFlingListener() {
        return recyclerView.getOnFlingListener();
    }

    @Nullable
    public RecyclerView.LayoutManager getLayoutManager() {
        return recyclerView.getLayoutManager();
    }

    @NonNull
    public RecyclerView.RecycledViewPool getRecycledViewPool() {
        return recyclerView.getRecycledViewPool();
    }

    public void setRecycledViewPool(@Nullable RecyclerView.RecycledViewPool pool) {
        recyclerView.setRecycledViewPool(pool);
    }

    public void setViewCacheExtension(@Nullable RecyclerView.ViewCacheExtension extension) {
        recyclerView.setViewCacheExtension(extension);
    }

    public void setItemViewCacheSize(int size) {
        recyclerView.setItemViewCacheSize(size);
    }

    public int getScrollState() {
        return recyclerView.getScrollState();
    }


    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration decor, int index) {
        recyclerView.addItemDecoration(decor, index);
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration decor) {

        recyclerView.addItemDecoration(decor);
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int index) {
        return recyclerView.getItemDecorationAt(index);
    }

    public int getItemDecorationCount() {
        return recyclerView.getItemDecorationCount();
    }

    public void removeItemDecorationAt(int index) {
        recyclerView.removeItemDecorationAt(index);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration decor) {
        recyclerView.removeItemDecoration(decor);
    }

    public void setChildDrawingOrderCallback(@Nullable RecyclerView.ChildDrawingOrderCallback childDrawingOrderCallback) {
        recyclerView.setChildDrawingOrderCallback(childDrawingOrderCallback);
    }

    public void addOnScrollListener(@NonNull RecyclerView.OnScrollListener listener) {
        recyclerView.addOnScrollListener(listener);
    }

    public void removeOnScrollListener(@NonNull RecyclerView.OnScrollListener listener) {
        recyclerView.removeOnScrollListener(listener);

    }

    public void clearOnScrollListeners() {
        recyclerView.clearOnScrollListeners();

    }

    public void scrollToPosition(int position) {
        recyclerView.scrollToPosition(position);
    }


    public void smoothScrollToPosition(int position) {
        recyclerView.smoothScrollToPosition(position);
    }

    public void scrollBy(int x, int y) {
        recyclerView.scrollBy(x, y);
    }

    public int computeHorizontalScrollOffset() {
        return recyclerView.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return recyclerView.computeHorizontalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return recyclerView.computeHorizontalScrollRange();
    }

    public int computeVerticalScrollOffset() {
        return recyclerView.computeVerticalScrollOffset();
    }

    public int computeVerticalScrollExtent() {
        return recyclerView.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollRange() {
        return recyclerView.computeVerticalScrollRange();
    }

    public void setLayoutFrozen(boolean frozen) {
        recyclerView.setLayoutFrozen(frozen);
    }

    public boolean isLayoutFrozen() {
        return recyclerView.isLayoutFrozen();
    }

    public void smoothScrollBy(@Px int dx, @Px int dy) {
        recyclerView.smoothScrollBy(dx, dy, (Interpolator) null);
    }

    public void smoothScrollBy(@Px int dx, @Px int dy, @Nullable Interpolator interpolator) {
        recyclerView.smoothScrollBy(dx, dy, interpolator);
    }

    public boolean fling(int velocityX, int velocityY) {
        return recyclerView.fling(velocityX, velocityY);
    }

    public void stopScroll() {
        recyclerView.stopScroll();
    }

    public int getMinFlingVelocity() {
        return recyclerView.getMinFlingVelocity();
    }

    public int getMaxFlingVelocity() {
        return recyclerView.getMaxFlingVelocity();
    }

    public void setEdgeEffectFactory(@NonNull RecyclerView.EdgeEffectFactory edgeEffectFactory) {
        recyclerView.setEdgeEffectFactory(edgeEffectFactory);
    }

    @NonNull
    public RecyclerView.EdgeEffectFactory getEdgeEffectFactory() {
        return recyclerView.getEdgeEffectFactory();
    }

    public View focusSearch(View focused, int direction) {
        return recyclerView.focusSearch(focused, direction);
    }

    public boolean requestChildRectangleOnScreen(View child, Rect rect, boolean immediate) {
        return recyclerView.requestChildRectangleOnScreen(child, rect, immediate);
    }

    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        recyclerView.addFocusables(views, direction, focusableMode);
    }

    public boolean isAttachedToWindow() {
        return recyclerView.isAttachedToWindow();
    }

    public void addOnItemTouchListener(@NonNull RecyclerView.OnItemTouchListener listener) {
        recyclerView.addOnItemTouchListener(listener);
    }

    public void removeOnItemTouchListener(@NonNull RecyclerView.OnItemTouchListener listener) {
        recyclerView.removeOnItemTouchListener(listener);
    }

    public boolean onInterceptTouchEvent(MotionEvent e) {
        return recyclerView.onInterceptTouchEvent(e);
    }

    public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        recyclerView.requestDisallowInterceptTouchEvent(disallowIntercept);
    }

    public boolean onTouchEvent(MotionEvent e) {
        return recyclerView.onTouchEvent(e);
    }

    public boolean onGenericMotionEvent(MotionEvent event) {
        return recyclerView.onGenericMotionEvent(event);
    }

    public void setItemAnimator(@Nullable RecyclerView.ItemAnimator animator) {
        recyclerView.setItemAnimator(animator);
    }

    public boolean isComputingLayout() {
        return recyclerView.isComputingLayout();
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
        recyclerView.sendAccessibilityEventUnchecked(event);
    }

    @Nullable
    public RecyclerView.ItemAnimator getItemAnimator() {
        return recyclerView.getItemAnimator();
    }

    public boolean isAnimating() {
        return recyclerView.isAnimating();
    }

    public void invalidateItemDecorations() {
        recyclerView.invalidateItemDecorations();
    }

    public boolean getPreserveFocusAfterLayout() {
        return recyclerView.getPreserveFocusAfterLayout();
    }

    public void setPreserveFocusAfterLayout(boolean preserveFocusAfterLayout) {
        recyclerView.setPreserveFocusAfterLayout(preserveFocusAfterLayout);
    }

    public RecyclerView.ViewHolder getChildViewHolder(@NonNull View child) {
        return recyclerView.getChildViewHolder(child);
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        return recyclerView.findContainingItemView(view);
    }

    @Nullable
    public RecyclerView.ViewHolder findContainingViewHolder(@NonNull View view) {
        return recyclerView.findContainingViewHolder(view);
    }

    public int getChildAdapterPosition(@NonNull View child) {
        return recyclerView.getChildAdapterPosition(child);
    }

    public int getChildLayoutPosition(@NonNull View child) {
        return recyclerView.getChildLayoutPosition(child);
    }

    public long getChildItemId(@NonNull View child) {
        return recyclerView.getChildItemId(child);
    }


    @Nullable
    public RecyclerView.ViewHolder findViewHolderForLayoutPosition(int position) {
        return recyclerView.findViewHolderForLayoutPosition(position);
    }

    @Nullable
    public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int position) {
        return recyclerView.findViewHolderForAdapterPosition(position);
    }

    public RecyclerView.ViewHolder findViewHolderForItemId(long id) {
        return recyclerView.findViewHolderForItemId(id);
    }

    @Nullable
    public View findChildViewUnder(float x, float y) {
        return recyclerView.findChildViewUnder(x, y);
    }

    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        return recyclerView.drawChild(canvas, child, drawingTime);
    }

    public void offsetChildrenVertical(@Px int dy) {
        recyclerView.offsetChildrenVertical(dy);

    }

    public void offsetChildrenHorizontal(@Px int dx) {
        recyclerView.offsetChildrenHorizontal(dx);
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect outBounds) {
        recyclerView.getDecoratedBoundsWithMargins(view, outBounds);
    }


    public boolean hasPendingAdapterUpdates() {
        return recyclerView.hasPendingAdapterUpdates();
    }


    public void setNestedScrollingEnabled(boolean enabled) {
        recyclerView.setNestedScrollingEnabled(enabled);
    }

    public boolean isNestedScrollingEnabled() {
        return recyclerView.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int axes) {
        return recyclerView.startNestedScroll(axes);
    }

    public boolean startNestedScroll(int axes, int type) {
        return recyclerView.startNestedScroll(axes, type);
    }

    public void stopNestedScroll() {
        recyclerView.stopNestedScroll();
    }

    public void stopNestedScroll(int type) {
        recyclerView.stopNestedScroll();
    }

    public boolean hasNestedScrollingParent() {
        return recyclerView.hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int type) {
        return recyclerView.hasNestedScrollingParent(type);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return recyclerView.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow);
    }

    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
        return recyclerView.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return recyclerView.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow, int type) {
        return recyclerView.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow, type);
    }

    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return recyclerView.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return recyclerView.dispatchNestedPreFling(velocityX, velocityY);
    }

    public void setEmptyViewRes(@LayoutRes int emptyViewRes) {
        emptyView = LayoutInflater.from(getContext()).inflate(emptyViewRes, this, false);
        emptyObserver.onChanged();
    }

    public View getEmptyView() {
        return emptyView;
    }
}
