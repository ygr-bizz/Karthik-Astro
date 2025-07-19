package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] SNACKBAR_BUTTON_STYLE_ATTR = {R.attr.snackbarButtonStyle};
    private final AccessibilityManager accessibilityManager;
    private BaseTransientBottomBar.BaseCallback<Snackbar> callback;
    private boolean hasAction;

    public static class Callback extends BaseTransientBottomBar.BaseCallback<Snackbar> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public void onShown(Snackbar sb) {
        }

        public void onDismissed(Snackbar transientBottomBar, int event) {
        }
    }

    private Snackbar(ViewGroup parent, View content, ContentViewCallback contentViewCallback) {
        super(parent, content, contentViewCallback);
        this.accessibilityManager = (AccessibilityManager) parent.getContext().getSystemService("accessibility");
    }

    public void show() {
        super.show();
    }

    public void dismiss() {
        super.dismiss();
    }

    public boolean isShown() {
        return super.isShown();
    }

    public static Snackbar make(View view, CharSequence text, int duration) {
        ViewGroup parent = findSuitableParent(view);
        if (parent != null) {
            SnackbarContentLayout content = (SnackbarContentLayout) LayoutInflater.from(parent.getContext()).inflate(hasSnackbarButtonStyleAttr(parent.getContext()) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, parent, false);
            Snackbar snackbar = new Snackbar(parent, content, content);
            snackbar.setText(text);
            snackbar.setDuration(duration);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    protected static boolean hasSnackbarButtonStyleAttr(Context context) {
        TypedArray a = context.obtainStyledAttributes(SNACKBAR_BUTTON_STYLE_ATTR);
        int snackbarButtonStyleResId = a.getResourceId(0, -1);
        a.recycle();
        if (snackbarButtonStyleResId != -1) {
            return true;
        }
        return false;
    }

    public static Snackbar make(View view, int resId, int duration) {
        return make(view, view.getResources().getText(resId), duration);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [android.view.ViewParent] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.ViewGroup findSuitableParent(android.view.View r3) {
        /*
            r0 = 0
        L_0x0001:
            boolean r1 = r3 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r1 == 0) goto L_0x0009
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            return r1
        L_0x0009:
            boolean r1 = r3 instanceof android.widget.FrameLayout
            if (r1 == 0) goto L_0x001d
            int r1 = r3.getId()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r1 != r2) goto L_0x001a
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            return r1
        L_0x001a:
            r0 = r3
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
        L_0x001d:
            if (r3 == 0) goto L_0x002d
            android.view.ViewParent r1 = r3.getParent()
            boolean r2 = r1 instanceof android.view.View
            if (r2 == 0) goto L_0x002b
            r2 = r1
            android.view.View r2 = (android.view.View) r2
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            r3 = r2
        L_0x002d:
            if (r3 != 0) goto L_0x0030
            return r0
        L_0x0030:
            goto L_0x0001
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.Snackbar.findSuitableParent(android.view.View):android.view.ViewGroup");
    }

    public Snackbar setText(CharSequence message) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setText(message);
        return this;
    }

    public Snackbar setText(int resId) {
        return setText(getContext().getText(resId));
    }

    public Snackbar setAction(int resId, View.OnClickListener listener) {
        return setAction(getContext().getText(resId), listener);
    }

    public Snackbar setAction(CharSequence text, final View.OnClickListener listener) {
        TextView tv = ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(text) || listener == null) {
            tv.setVisibility(8);
            tv.setOnClickListener((View.OnClickListener) null);
            this.hasAction = false;
        } else {
            this.hasAction = true;
            tv.setVisibility(0);
            tv.setText(text);
            tv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    listener.onClick(view);
                    Snackbar.this.dispatchDismiss(1);
                }
            });
        }
        return this;
    }

    public int getDuration() {
        int userSetDuration = super.getDuration();
        if (userSetDuration == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.accessibilityManager.getRecommendedTimeoutMillis(userSetDuration, (this.hasAction ? 4 : 0) | 1 | 2);
        } else if (!this.hasAction || !this.accessibilityManager.isTouchExplorationEnabled()) {
            return userSetDuration;
        } else {
            return -2;
        }
    }

    public Snackbar setTextColor(ColorStateList colors) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(colors);
        return this;
    }

    public Snackbar setTextColor(int color) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getMessageView().setTextColor(color);
        return this;
    }

    public Snackbar setActionTextColor(ColorStateList colors) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(colors);
        return this;
    }

    public Snackbar setActionTextColor(int color) {
        ((SnackbarContentLayout) this.view.getChildAt(0)).getActionView().setTextColor(color);
        return this;
    }

    public Snackbar setBackgroundTint(int color) {
        Drawable background = this.view.getBackground();
        if (background != null) {
            Drawable background2 = background.mutate();
            if (Build.VERSION.SDK_INT >= 22) {
                DrawableCompat.setTint(background2, color);
            } else {
                background2.setColorFilter(color, PorterDuff.Mode.SRC_IN);
            }
        }
        return this;
    }

    public Snackbar setBackgroundTintList(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.view.getBackground().mutate(), colorStateList);
        return this;
    }

    @Deprecated
    public Snackbar setCallback(Callback callback2) {
        BaseTransientBottomBar.BaseCallback<Snackbar> baseCallback = this.callback;
        if (baseCallback != null) {
            removeCallback(baseCallback);
        }
        if (callback2 != null) {
            addCallback(callback2);
        }
        this.callback = callback2;
        return this;
    }

    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context) {
            super(context);
        }

        public SnackbarLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            int childCount = getChildCount();
            int availableWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                if (child.getLayoutParams().width == -1) {
                    child.measure(View.MeasureSpec.makeMeasureSpec(availableWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(child.getMeasuredHeight(), BasicMeasure.EXACTLY));
                }
            }
        }
    }
}
