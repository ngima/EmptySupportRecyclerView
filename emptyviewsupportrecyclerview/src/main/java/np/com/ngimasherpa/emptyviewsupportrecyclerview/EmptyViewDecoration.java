package np.com.ngimasherpa.emptyviewsupportrecyclerview;

import android.graphics.Canvas;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

public class EmptyViewDecoration extends RecyclerView.ItemDecoration {

    private int layoutResId;

    public EmptyViewDecoration(@LayoutRes int layoutResId) {
        this.layoutResId = layoutResId;
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        canvas.save();
//        final int leftWithMargin = convertDpToPixel(56);
        final int right = parent.getWidth();

        final int childCount = parent.getChildCount();
        if (childCount != 0) {
            canvas.restore();
            return;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        view.layout(0, 56, parent.getWidth(), 300);

//Translate the canvas so the view is drawn at the proper coordinates
        canvas.save();
        canvas.translate(0, 56);

//Draw the View and clear the translation
        view.draw(canvas);
        canvas.restore();
    }
}
