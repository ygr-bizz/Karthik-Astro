package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;

public class BottomNavigationView extends FrameLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomNavigationView;
    private static final int MENU_PRESENTER_ID = 1;
    private ColorStateList itemRippleColor;
    private final MenuBuilder menu;
    private MenuInflater menuInflater;
    final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter;
    /* access modifiers changed from: private */
    public OnNavigationItemReselectedListener reselectedListener;
    /* access modifiers changed from: private */
    public OnNavigationItemSelectedListener selectedListener;

    public interface OnNavigationItemReselectedListener {
        void onNavigationItemReselected(MenuItem menuItem);
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public BottomNavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(ThemeEnforcement.createThemedContext(context, attrs, defStyleAttr, DEF_STYLE_RES), attrs, defStyleAttr);
        BottomNavigationPresenter bottomNavigationPresenter = new BottomNavigationPresenter();
        this.presenter = bottomNavigationPresenter;
        Context context2 = getContext();
        BottomNavigationMenu bottomNavigationMenu = new BottomNavigationMenu(context2);
        this.menu = bottomNavigationMenu;
        BottomNavigationMenuView bottomNavigationMenuView = new BottomNavigationMenuView(context2);
        this.menuView = bottomNavigationMenuView;
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 17;
        bottomNavigationMenuView.setLayoutParams(params);
        bottomNavigationPresenter.setBottomNavigationMenuView(bottomNavigationMenuView);
        bottomNavigationPresenter.setId(1);
        bottomNavigationMenuView.setPresenter(bottomNavigationPresenter);
        bottomNavigationMenu.addMenuPresenter(bottomNavigationPresenter);
        bottomNavigationPresenter.initForMenu(getContext(), bottomNavigationMenu);
        TintTypedArray a = ThemeEnforcement.obtainTintedStyledAttributes(context2, attrs, R.styleable.BottomNavigationView, defStyleAttr, R.style.Widget_Design_BottomNavigationView, R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive);
        if (a.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
            bottomNavigationMenuView.setIconTintList(a.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
        } else {
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.createDefaultColorStateList(16842808));
        }
        setItemIconSize(a.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (a.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(a.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
        }
        if (a.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(a.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
        }
        if (a.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
            setItemTextColor(a.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, createMaterialShapeDrawableBackground(context2));
        }
        if (a.hasValue(R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.setElevation(this, (float) a.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), MaterialResources.getColorStateList(context2, a, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(a.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(a.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int itemBackground = a.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        if (itemBackground != 0) {
            bottomNavigationMenuView.setItemBackgroundRes(itemBackground);
        } else {
            setItemRippleColor(MaterialResources.getColorStateList(context2, a, R.styleable.BottomNavigationView_itemRippleColor));
        }
        if (a.hasValue(R.styleable.BottomNavigationView_menu)) {
            inflateMenu(a.getResourceId(R.styleable.BottomNavigationView_menu, 0));
        }
        a.recycle();
        addView(bottomNavigationMenuView, params);
        if (Build.VERSION.SDK_INT < 21) {
            addCompatibilityTopDivider(context2);
        }
        bottomNavigationMenu.setCallback(new MenuBuilder.Callback() {
            public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                if (BottomNavigationView.this.reselectedListener != null && item.getItemId() == BottomNavigationView.this.getSelectedItemId()) {
                    BottomNavigationView.this.reselectedListener.onNavigationItemReselected(item);
                    return true;
                } else if (BottomNavigationView.this.selectedListener == null || BottomNavigationView.this.selectedListener.onNavigationItemSelected(item)) {
                    return false;
                } else {
                    return true;
                }
            }

            public void onMenuModeChange(MenuBuilder menu) {
            }
        });
        applyWindowInsets();
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat insets, ViewUtils.RelativePadding initialPadding) {
                initialPadding.bottom += insets.getSystemWindowInsetBottom();
                initialPadding.applyToView(view);
                return insets;
            }
        });
    }

    private MaterialShapeDrawable createMaterialShapeDrawableBackground(Context context) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        Drawable originalBackground = getBackground();
        if (originalBackground instanceof ColorDrawable) {
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) originalBackground).getColor()));
        }
        materialShapeDrawable.initializeElevationOverlay(context);
        return materialShapeDrawable;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    public void setElevation(float elevation) {
        super.setElevation(elevation);
        MaterialShapeUtils.setElevation(this, elevation);
    }

    public void setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener listener) {
        this.selectedListener = listener;
    }

    public void setOnNavigationItemReselectedListener(OnNavigationItemReselectedListener listener) {
        this.reselectedListener = listener;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public void inflateMenu(int resId) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(resId, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public void setItemIconTintList(ColorStateList tint) {
        this.menuView.setIconTintList(tint);
    }

    public void setItemIconSize(int iconSize) {
        this.menuView.setItemIconSize(iconSize);
    }

    public void setItemIconSizeRes(int iconSizeRes) {
        setItemIconSize(getResources().getDimensionPixelSize(iconSizeRes));
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public void setItemTextColor(ColorStateList textColor) {
        this.menuView.setItemTextColor(textColor);
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public void setItemBackgroundResource(int resId) {
        this.menuView.setItemBackgroundRes(resId);
        this.itemRippleColor = null;
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public void setItemBackground(Drawable background) {
        this.menuView.setItemBackground(background);
        this.itemRippleColor = null;
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public void setItemRippleColor(ColorStateList itemRippleColor2) {
        if (this.itemRippleColor != itemRippleColor2) {
            this.itemRippleColor = itemRippleColor2;
            if (itemRippleColor2 == null) {
                this.menuView.setItemBackground((Drawable) null);
                return;
            }
            ColorStateList rippleDrawableColor = RippleUtils.convertToRippleDrawableColor(itemRippleColor2);
            if (Build.VERSION.SDK_INT >= 21) {
                this.menuView.setItemBackground(new RippleDrawable(rippleDrawableColor, (Drawable) null, (Drawable) null));
                return;
            }
            GradientDrawable rippleDrawable = new GradientDrawable();
            rippleDrawable.setCornerRadius(1.0E-5f);
            Drawable rippleDrawableCompat = DrawableCompat.wrap(rippleDrawable);
            DrawableCompat.setTintList(rippleDrawableCompat, rippleDrawableColor);
            this.menuView.setItemBackground(rippleDrawableCompat);
        } else if (itemRippleColor2 == null && this.menuView.getItemBackground() != null) {
            this.menuView.setItemBackground((Drawable) null);
        }
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void setSelectedItemId(int itemId) {
        MenuItem item = this.menu.findItem(itemId);
        if (item != null && !this.menu.performItemAction(item, this.presenter, 0)) {
            item.setChecked(true);
        }
    }

    public void setLabelVisibilityMode(int labelVisibilityMode) {
        if (this.menuView.getLabelVisibilityMode() != labelVisibilityMode) {
            this.menuView.setLabelVisibilityMode(labelVisibilityMode);
            this.presenter.updateMenuView(false);
        }
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public void setItemTextAppearanceInactive(int textAppearanceRes) {
        this.menuView.setItemTextAppearanceInactive(textAppearanceRes);
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public void setItemTextAppearanceActive(int textAppearanceRes) {
        this.menuView.setItemTextAppearanceActive(textAppearanceRes);
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public void setItemHorizontalTranslationEnabled(boolean itemHorizontalTranslationEnabled) {
        if (this.menuView.isItemHorizontalTranslationEnabled() != itemHorizontalTranslationEnabled) {
            this.menuView.setItemHorizontalTranslationEnabled(itemHorizontalTranslationEnabled);
            this.presenter.updateMenuView(false);
        }
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    public BadgeDrawable getBadge(int menuItemId) {
        return this.menuView.getBadge(menuItemId);
    }

    public BadgeDrawable getOrCreateBadge(int menuItemId) {
        return this.menuView.getOrCreateBadge(menuItemId);
    }

    public void removeBadge(int menuItemId) {
        this.menuView.removeBadge(menuItemId);
    }

    private void addCompatibilityTopDivider(Context context) {
        View divider = new View(context);
        divider.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
        divider.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(divider);
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(getContext());
        }
        return this.menuInflater;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.menuPresenterState = new Bundle();
        this.menu.savePresenterStates(savedState.menuPresenterState);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuPresenterState);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, (ClassLoader) null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        Bundle menuPresenterState;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        public SavedState(Parcel source, ClassLoader loader) {
            super(source, loader);
            readFromParcel(source, loader == null ? getClass().getClassLoader() : loader);
        }

        public void writeToParcel(Parcel out, int flags) {
            super.writeToParcel(out, flags);
            out.writeBundle(this.menuPresenterState);
        }

        private void readFromParcel(Parcel in, ClassLoader loader) {
            this.menuPresenterState = in.readBundle(loader);
        }
    }
}
