package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

public class SwitchCompat extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property<SwitchCompat, Float> THUMB_POS = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        public Float get(SwitchCompat object) {
            return Float.valueOf(object.mThumbPosition);
        }

        public void set(SwitchCompat object, Float value) {
            object.setThumbPosition(value.floatValue());
        }
    };
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE = 0;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchCompat(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        TintTypedArray a = TintTypedArray.obtainStyledAttributes(context, attrs, R.styleable.SwitchCompat, defStyleAttr, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.SwitchCompat, attrs, a.getWrappedTypeArray(), defStyleAttr, 0);
        Drawable drawable = a.getDrawable(R.styleable.SwitchCompat_android_thumb);
        this.mThumbDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        Drawable drawable2 = a.getDrawable(R.styleable.SwitchCompat_track);
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.mTextOn = a.getText(R.styleable.SwitchCompat_android_textOn);
        this.mTextOff = a.getText(R.styleable.SwitchCompat_android_textOff);
        this.mShowText = a.getBoolean(R.styleable.SwitchCompat_showText, true);
        this.mThumbTextPadding = a.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.mSwitchMinWidth = a.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.mSwitchPadding = a.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
        this.mSplitTrack = a.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList thumbTintList = a.getColorStateList(R.styleable.SwitchCompat_thumbTint);
        if (thumbTintList != null) {
            this.mThumbTintList = thumbTintList;
            this.mHasThumbTint = true;
        }
        PorterDuff.Mode thumbTintMode = DrawableUtils.parseTintMode(a.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.mThumbTintMode != thumbTintMode) {
            this.mThumbTintMode = thumbTintMode;
            this.mHasThumbTintMode = true;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            applyThumbTint();
        }
        ColorStateList trackTintList = a.getColorStateList(R.styleable.SwitchCompat_trackTint);
        if (trackTintList != null) {
            this.mTrackTintList = trackTintList;
            this.mHasTrackTint = true;
        }
        PorterDuff.Mode trackTintMode = DrawableUtils.parseTintMode(a.getInt(R.styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.mTrackTintMode != trackTintMode) {
            this.mTrackTintMode = trackTintMode;
            this.mHasTrackTintMode = true;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            applyTrackTint();
        }
        int appearance = a.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (appearance != 0) {
            setSwitchTextAppearance(context, appearance);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attrs, defStyleAttr);
        a.recycle();
        ViewConfiguration config = ViewConfiguration.get(context);
        this.mTouchSlop = config.getScaledTouchSlop();
        this.mMinFlingVelocity = config.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int resid) {
        TintTypedArray appearance = TintTypedArray.obtainStyledAttributes(context, resid, R.styleable.TextAppearance);
        ColorStateList colors = appearance.getColorStateList(R.styleable.TextAppearance_android_textColor);
        if (colors != null) {
            this.mTextColors = colors;
        } else {
            this.mTextColors = getTextColors();
        }
        int ts = appearance.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (!(ts == 0 || ((float) ts) == this.mTextPaint.getTextSize())) {
            this.mTextPaint.setTextSize((float) ts);
            requestLayout();
        }
        setSwitchTypefaceByIndex(appearance.getInt(R.styleable.TextAppearance_android_typeface, -1), appearance.getInt(R.styleable.TextAppearance_android_textStyle, -1));
        if (appearance.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
            this.mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());
        } else {
            this.mSwitchTransformationMethod = null;
        }
        appearance.recycle();
    }

    private void setSwitchTypefaceByIndex(int typefaceIndex, int styleIndex) {
        Typeface tf = null;
        if (typefaceIndex == 1) {
            tf = Typeface.SANS_SERIF;
        } else if (typefaceIndex == 2) {
            tf = Typeface.SERIF;
        } else if (typefaceIndex == 3) {
            tf = Typeface.MONOSPACE;
        }
        setSwitchTypeface(tf, styleIndex);
    }

    public void setSwitchTypeface(Typeface tf, int style) {
        Typeface tf2;
        float f = 0.0f;
        boolean z = false;
        if (style > 0) {
            if (tf == null) {
                tf2 = Typeface.defaultFromStyle(style);
            } else {
                tf2 = Typeface.create(tf, style);
            }
            setSwitchTypeface(tf2);
            int need = (~(tf2 != null ? tf2.getStyle() : 0)) & style;
            TextPaint textPaint = this.mTextPaint;
            if ((need & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            TextPaint textPaint2 = this.mTextPaint;
            if ((need & 2) != 0) {
                f = -0.25f;
            }
            textPaint2.setTextSkewX(f);
            return;
        }
        this.mTextPaint.setFakeBoldText(false);
        this.mTextPaint.setTextSkewX(0.0f);
        setSwitchTypeface(tf);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.mTextPaint.getTypeface() != null && !this.mTextPaint.getTypeface().equals(typeface)) || (this.mTextPaint.getTypeface() == null && typeface != null)) {
            this.mTextPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int pixels) {
        this.mSwitchPadding = pixels;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public void setSwitchMinWidth(int pixels) {
        this.mSwitchMinWidth = pixels;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public void setThumbTextPadding(int pixels) {
        this.mThumbTextPadding = pixels;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public void setTrackDrawable(Drawable track) {
        Drawable drawable = this.mTrackDrawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
        this.mTrackDrawable = track;
        if (track != null) {
            track.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int resId) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public void setTrackTintList(ColorStateList tint) {
        this.mTrackTintList = tint;
        this.mHasTrackTint = true;
        applyTrackTint();
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public void setTrackTintMode(PorterDuff.Mode tintMode) {
        this.mTrackTintMode = tintMode;
        this.mHasTrackTintMode = true;
        applyTrackTint();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    private void applyTrackTint() {
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasTrackTint || this.mHasTrackTintMode) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.mTrackDrawable = mutate;
            if (this.mHasTrackTint) {
                DrawableCompat.setTintList(mutate, this.mTrackTintList);
            }
            if (this.mHasTrackTintMode) {
                DrawableCompat.setTintMode(this.mTrackDrawable, this.mTrackTintMode);
            }
            if (this.mTrackDrawable.isStateful()) {
                this.mTrackDrawable.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable thumb) {
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
        this.mThumbDrawable = thumb;
        if (thumb != null) {
            thumb.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int resId) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), resId));
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public void setThumbTintList(ColorStateList tint) {
        this.mThumbTintList = tint;
        this.mHasThumbTint = true;
        applyThumbTint();
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public void setThumbTintMode(PorterDuff.Mode tintMode) {
        this.mThumbTintMode = tintMode;
        this.mHasThumbTintMode = true;
        applyThumbTint();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    private void applyThumbTint() {
        Drawable drawable = this.mThumbDrawable;
        if (drawable == null) {
            return;
        }
        if (this.mHasThumbTint || this.mHasThumbTintMode) {
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            this.mThumbDrawable = mutate;
            if (this.mHasThumbTint) {
                DrawableCompat.setTintList(mutate, this.mThumbTintList);
            }
            if (this.mHasThumbTintMode) {
                DrawableCompat.setTintMode(this.mThumbDrawable, this.mThumbTintMode);
            }
            if (this.mThumbDrawable.isStateful()) {
                this.mThumbDrawable.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean splitTrack) {
        this.mSplitTrack = splitTrack;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public void setTextOn(CharSequence textOn) {
        this.mTextOn = textOn;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public void setTextOff(CharSequence textOff) {
        this.mTextOff = textOff;
        requestLayout();
    }

    public void setShowText(boolean showText) {
        if (this.mShowText != showText) {
            this.mShowText = showText;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int thumbHeight;
        int thumbWidth;
        int maxTextWidth;
        int trackHeight;
        if (this.mShowText) {
            if (this.mOnLayout == null) {
                this.mOnLayout = makeLayout(this.mTextOn);
            }
            if (this.mOffLayout == null) {
                this.mOffLayout = makeLayout(this.mTextOff);
            }
        }
        Rect padding = this.mTempRect;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.getPadding(padding);
            thumbWidth = (this.mThumbDrawable.getIntrinsicWidth() - padding.left) - padding.right;
            thumbHeight = this.mThumbDrawable.getIntrinsicHeight();
        } else {
            thumbWidth = 0;
            thumbHeight = 0;
        }
        if (this.mShowText) {
            maxTextWidth = Math.max(this.mOnLayout.getWidth(), this.mOffLayout.getWidth()) + (this.mThumbTextPadding * 2);
        } else {
            maxTextWidth = 0;
        }
        this.mThumbWidth = Math.max(maxTextWidth, thumbWidth);
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(padding);
            trackHeight = this.mTrackDrawable.getIntrinsicHeight();
        } else {
            padding.setEmpty();
            trackHeight = 0;
        }
        int paddingLeft = padding.left;
        int paddingRight = padding.right;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            Rect inset = DrawableUtils.getOpticalBounds(drawable3);
            paddingLeft = Math.max(paddingLeft, inset.left);
            paddingRight = Math.max(paddingRight, inset.right);
        }
        int switchWidth = Math.max(this.mSwitchMinWidth, (this.mThumbWidth * 2) + paddingLeft + paddingRight);
        int switchHeight = Math.max(trackHeight, thumbHeight);
        this.mSwitchWidth = switchWidth;
        this.mSwitchHeight = switchHeight;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (getMeasuredHeight() < switchHeight) {
            setMeasuredDimension(getMeasuredWidthAndState(), switchHeight);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        CharSequence text = isChecked() ? this.mTextOn : this.mTextOff;
        if (text != null) {
            event.getText().add(text);
        }
    }

    private Layout makeLayout(CharSequence text) {
        CharSequence transformed;
        TransformationMethod transformationMethod = this.mSwitchTransformationMethod;
        if (transformationMethod != null) {
            transformed = transformationMethod.getTransformation(text, this);
        } else {
            transformed = text;
        }
        TextPaint textPaint = this.mTextPaint;
        return new StaticLayout(transformed, textPaint, transformed != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformed, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean hitThumb(float x, float y) {
        if (this.mThumbDrawable == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.mThumbDrawable.getPadding(this.mTempRect);
        int i = this.mSwitchTop;
        int i2 = this.mTouchSlop;
        int thumbTop = i - i2;
        int thumbLeft = (this.mSwitchLeft + thumbOffset) - i2;
        int i3 = this.mThumbWidth + thumbLeft + this.mTempRect.left + this.mTempRect.right;
        int i4 = this.mTouchSlop;
        int thumbRight = i3 + i4;
        int thumbBottom = this.mSwitchBottom + i4;
        if (x <= ((float) thumbLeft) || x >= ((float) thumbRight) || y <= ((float) thumbTop) || y >= ((float) thumbBottom)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            android.view.VelocityTracker r0 = r9.mVelocityTracker
            r0.addMovement(r10)
            int r0 = r10.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009f
            r2 = 2
            if (r0 == r1) goto L_0x008b
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008b
            goto L_0x00b9
        L_0x0016:
            int r3 = r9.mTouchMode
            if (r3 == r1) goto L_0x0055
            if (r3 == r2) goto L_0x001d
            goto L_0x007c
        L_0x001d:
            float r2 = r10.getX()
            int r3 = r9.getThumbScrollRange()
            float r4 = r9.mTouchX
            float r4 = r2 - r4
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            if (r3 == 0) goto L_0x0032
            float r7 = (float) r3
            float r7 = r4 / r7
            goto L_0x003b
        L_0x0032:
            int r7 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x0039
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003b
        L_0x0039:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003b:
            boolean r8 = androidx.appcompat.widget.ViewUtils.isLayoutRtl(r9)
            if (r8 == 0) goto L_0x0042
            float r7 = -r7
        L_0x0042:
            float r8 = r9.mThumbPosition
            float r8 = r8 + r7
            float r5 = constrain(r8, r6, r5)
            float r6 = r9.mThumbPosition
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0054
            r9.mTouchX = r2
            r9.setThumbPosition(r5)
        L_0x0054:
            return r1
        L_0x0055:
            float r3 = r10.getX()
            float r4 = r10.getY()
            float r5 = r9.mTouchX
            float r5 = r3 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r9.mTouchSlop
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 > 0) goto L_0x007d
            float r5 = r9.mTouchY
            float r5 = r4 - r5
            float r5 = java.lang.Math.abs(r5)
            int r6 = r9.mTouchSlop
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            goto L_0x00b9
        L_0x007d:
            r9.mTouchMode = r2
            android.view.ViewParent r2 = r9.getParent()
            r2.requestDisallowInterceptTouchEvent(r1)
            r9.mTouchX = r3
            r9.mTouchY = r4
            return r1
        L_0x008b:
            int r3 = r9.mTouchMode
            if (r3 != r2) goto L_0x0096
            r9.stopDrag(r10)
            super.onTouchEvent(r10)
            return r1
        L_0x0096:
            r1 = 0
            r9.mTouchMode = r1
            android.view.VelocityTracker r1 = r9.mVelocityTracker
            r1.clear()
            goto L_0x00b9
        L_0x009f:
            float r2 = r10.getX()
            float r3 = r10.getY()
            boolean r4 = r9.isEnabled()
            if (r4 == 0) goto L_0x00b9
            boolean r4 = r9.hitThumb(r2, r3)
            if (r4 == 0) goto L_0x00b9
            r9.mTouchMode = r1
            r9.mTouchX = r2
            r9.mTouchY = r3
        L_0x00b9:
            boolean r1 = super.onTouchEvent(r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private void cancelSuperTouch(MotionEvent ev) {
        MotionEvent cancel = MotionEvent.obtain(ev);
        cancel.setAction(3);
        super.onTouchEvent(cancel);
        cancel.recycle();
    }

    private void stopDrag(MotionEvent ev) {
        this.mTouchMode = 0;
        boolean newState = true;
        boolean commitChange = ev.getAction() == 1 && isEnabled();
        boolean oldState = isChecked();
        if (commitChange) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xvel = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xvel) <= ((float) this.mMinFlingVelocity)) {
                newState = getTargetCheckedState();
            } else if (!ViewUtils.isLayoutRtl(this) ? xvel <= 0.0f : xvel >= 0.0f) {
                newState = false;
            }
        } else {
            newState = oldState;
        }
        if (newState != oldState) {
            playSoundEffect(0);
        }
        setChecked(newState);
        cancelSuperTouch(ev);
    }

    private void animateThumbToCheckedState(boolean newCheckedState) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, THUMB_POS, new float[]{newCheckedState ? 1.0f : 0.0f});
        this.mPositionAnimator = ofFloat;
        ofFloat.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mPositionAnimator.setAutoCancel(true);
        }
        this.mPositionAnimator.start();
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.mThumbPosition > 0.5f;
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float position) {
        this.mThumbPosition = position;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean checked) {
        super.setChecked(checked);
        boolean checked2 = isChecked();
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this)) {
            cancelPositionAnimator();
            setThumbPosition(checked2 ? 1.0f : 0.0f);
            return;
        }
        animateThumbToCheckedState(checked2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int switchRight;
        int switchLeft;
        int switchBottom;
        int switchTop;
        super.onLayout(changed, left, top, right, bottom);
        int opticalInsetLeft = 0;
        int opticalInsetRight = 0;
        if (this.mThumbDrawable != null) {
            Rect trackPadding = this.mTempRect;
            Drawable drawable = this.mTrackDrawable;
            if (drawable != null) {
                drawable.getPadding(trackPadding);
            } else {
                trackPadding.setEmpty();
            }
            Rect insets = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
            opticalInsetLeft = Math.max(0, insets.left - trackPadding.left);
            opticalInsetRight = Math.max(0, insets.right - trackPadding.right);
        }
        if (ViewUtils.isLayoutRtl(this)) {
            switchLeft = getPaddingLeft() + opticalInsetLeft;
            switchRight = ((this.mSwitchWidth + switchLeft) - opticalInsetLeft) - opticalInsetRight;
        } else {
            switchRight = (getWidth() - getPaddingRight()) - opticalInsetRight;
            switchLeft = (switchRight - this.mSwitchWidth) + opticalInsetLeft + opticalInsetRight;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int i = this.mSwitchHeight;
            switchTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i / 2);
            switchBottom = i + switchTop;
        } else if (gravity != 80) {
            switchTop = getPaddingTop();
            switchBottom = this.mSwitchHeight + switchTop;
        } else {
            switchBottom = getHeight() - getPaddingBottom();
            switchTop = switchBottom - this.mSwitchHeight;
        }
        this.mSwitchLeft = switchLeft;
        this.mSwitchTop = switchTop;
        this.mSwitchBottom = switchBottom;
        this.mSwitchRight = switchRight;
    }

    public void draw(Canvas c) {
        Rect thumbInsets;
        Rect padding = this.mTempRect;
        int switchLeft = this.mSwitchLeft;
        int switchTop = this.mSwitchTop;
        int switchRight = this.mSwitchRight;
        int switchBottom = this.mSwitchBottom;
        int thumbInitialLeft = getThumbOffset() + switchLeft;
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            thumbInsets = DrawableUtils.getOpticalBounds(drawable);
        } else {
            thumbInsets = DrawableUtils.INSETS_NONE;
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(padding);
            thumbInitialLeft += padding.left;
            int trackLeft = switchLeft;
            int trackTop = switchTop;
            int trackRight = switchRight;
            int trackBottom = switchBottom;
            if (thumbInsets != null) {
                if (thumbInsets.left > padding.left) {
                    trackLeft += thumbInsets.left - padding.left;
                }
                if (thumbInsets.top > padding.top) {
                    trackTop += thumbInsets.top - padding.top;
                }
                if (thumbInsets.right > padding.right) {
                    trackRight -= thumbInsets.right - padding.right;
                }
                if (thumbInsets.bottom > padding.bottom) {
                    trackBottom -= thumbInsets.bottom - padding.bottom;
                }
            }
            this.mTrackDrawable.setBounds(trackLeft, trackTop, trackRight, trackBottom);
        }
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.getPadding(padding);
            int thumbLeft = thumbInitialLeft - padding.left;
            int thumbRight = this.mThumbWidth + thumbInitialLeft + padding.right;
            this.mThumbDrawable.setBounds(thumbLeft, switchTop, thumbRight, switchBottom);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, thumbLeft, switchTop, thumbRight, switchBottom);
            }
        }
        super.draw(c);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int cX;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        Rect padding = this.mTempRect;
        Drawable trackDrawable = this.mTrackDrawable;
        if (trackDrawable != null) {
            trackDrawable.getPadding(padding);
        } else {
            padding.setEmpty();
        }
        int switchTop = this.mSwitchTop;
        int switchBottom = this.mSwitchBottom;
        int switchInnerTop = padding.top + switchTop;
        int switchInnerBottom = switchBottom - padding.bottom;
        Drawable thumbDrawable = this.mThumbDrawable;
        if (trackDrawable != null) {
            if (!this.mSplitTrack || thumbDrawable == null) {
                trackDrawable.draw(canvas2);
            } else {
                Rect insets = DrawableUtils.getOpticalBounds(thumbDrawable);
                thumbDrawable.copyBounds(padding);
                padding.left += insets.left;
                padding.right -= insets.right;
                int saveCount = canvas.save();
                canvas2.clipRect(padding, Region.Op.DIFFERENCE);
                trackDrawable.draw(canvas2);
                canvas2.restoreToCount(saveCount);
            }
        }
        int saveCount2 = canvas.save();
        if (thumbDrawable != null) {
            thumbDrawable.draw(canvas2);
        }
        Layout switchText = getTargetCheckedState() ? this.mOnLayout : this.mOffLayout;
        if (switchText != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.mTextColors;
            if (colorStateList != null) {
                this.mTextPaint.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.mTextPaint.drawableState = drawableState;
            if (thumbDrawable != null) {
                Rect bounds = thumbDrawable.getBounds();
                cX = bounds.left + bounds.right;
            } else {
                cX = getWidth();
            }
            canvas2.translate((float) ((cX / 2) - (switchText.getWidth() / 2)), (float) (((switchInnerTop + switchInnerBottom) / 2) - (switchText.getHeight() / 2)));
            switchText.draw(canvas2);
        }
        canvas2.restoreToCount(saveCount2);
    }

    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int padding = super.getCompoundPaddingLeft() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return padding + this.mSwitchPadding;
        }
        return padding;
    }

    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int padding = super.getCompoundPaddingRight() + this.mSwitchWidth;
        if (!TextUtils.isEmpty(getText())) {
            return padding + this.mSwitchPadding;
        }
        return padding;
    }

    private int getThumbOffset() {
        float thumbPosition;
        if (ViewUtils.isLayoutRtl(this)) {
            thumbPosition = 1.0f - this.mThumbPosition;
        } else {
            thumbPosition = this.mThumbPosition;
        }
        return (int) ((((float) getThumbScrollRange()) * thumbPosition) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect insets;
        Drawable drawable = this.mTrackDrawable;
        if (drawable == null) {
            return 0;
        }
        Rect padding = this.mTempRect;
        drawable.getPadding(padding);
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            insets = DrawableUtils.getOpticalBounds(drawable2);
        } else {
            insets = DrawableUtils.INSETS_NONE;
        }
        return ((((this.mSwitchWidth - this.mThumbWidth) - padding.left) - padding.right) - insets.left) - insets.right;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int extraSpace) {
        int[] drawableState = super.onCreateDrawableState(extraSpace + 1);
        if (isChecked()) {
            mergeDrawableStates(drawableState, CHECKED_STATE_SET);
        }
        return drawableState;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] state = getDrawableState();
        boolean changed = false;
        Drawable thumbDrawable = this.mThumbDrawable;
        if (thumbDrawable != null && thumbDrawable.isStateful()) {
            changed = false | thumbDrawable.setState(state);
        }
        Drawable trackDrawable = this.mTrackDrawable;
        if (trackDrawable != null && trackDrawable.isStateful()) {
            changed |= trackDrawable.setState(state);
        }
        if (changed) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float x, float y) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(x, y);
        }
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, x, y);
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            DrawableCompat.setHotspot(drawable2, x, y);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable who) {
        return super.verifyDrawable(who) || who == this.mThumbDrawable || who == this.mTrackDrawable;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mThumbDrawable;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.mPositionAnimator.end();
            this.mPositionAnimator = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(ACCESSIBILITY_EVENT_CLASS_NAME);
        CharSequence switchText = isChecked() ? this.mTextOn : this.mTextOff;
        if (!TextUtils.isEmpty(switchText)) {
            CharSequence oldText = info.getText();
            if (TextUtils.isEmpty(oldText)) {
                info.setText(switchText);
                return;
            }
            StringBuilder newText = new StringBuilder();
            newText.append(oldText);
            newText.append(' ');
            newText.append(switchText);
            info.setText(newText);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, actionModeCallback));
    }

    private static float constrain(float amount, float low, float high) {
        if (amount < low) {
            return low;
        }
        return amount > high ? high : amount;
    }
}
