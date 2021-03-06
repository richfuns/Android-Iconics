package com.mikepenz.iconics.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.text.TextUtils;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.utils.Utils;
import com.mikepenz.iconics.view.R;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

/**
 * @author pa.gulko zTrap (07.07.2017)
 */
@RestrictTo(LIBRARY_GROUP)
public class IconicsViewsAttrsReader {

    //region IconicsImageView
    public static void readIconicsImageView(TypedArray a, IconicsDrawable icon) {
        icon.icon(a.getString(R.styleable.IconicsImageView_iiv_icon));
        if (!TextUtils.isEmpty(icon.getPlainIcon())) {
            int color = a.getColor(R.styleable.IconicsImageView_iiv_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsImageView_iiv_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsImageView_iiv_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsImageView_iiv_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
    }
    //endregion

    //region IconicsTextView

    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' < attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    public static void readIconicsTextView(Context ctx, TypedArray a, CompoundIconsBundle bundle) {
        //obtaining attributes for all icons
        IconicsDrawable allIconBundle = readIconicsTextViewAll(a, new IconicsDrawable(ctx));

        //obtaining attributes for start icons
        bundle.mStartIconBundle = readIconicsTextViewStart(ctx, a, allIconBundle);

        //obtaining attributes for top icons
        bundle.mTopIconBundle = readIconicsTextViewTop(ctx, a, allIconBundle);

        //obtaining attributes for end icons
        bundle.mEndIconBundle = readIconicsTextViewEnd(ctx, a, allIconBundle);

        //obtaining attributes for bottom icons
        bundle.mBottomIconBundle = readIconicsTextViewBottom(ctx, a, allIconBundle);
    }

    public static IconicsDrawable readIconicsTextViewAll(TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_all_icon);
        if (i != null) {
            icon.icon(i);
        }
        int color = a.getColor(R.styleable.IconicsTextView_iiv_all_color, Integer.MIN_VALUE);
        if (color != Integer.MIN_VALUE) {
            icon.color(color);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_size, -1);
        if (size != -1) {
            icon.sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_padding, -1);
        if (padding != -1) {
            icon.paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_all_contour_color, Integer.MIN_VALUE);
        if (contourColor != Integer.MIN_VALUE) {
            icon.contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_contour_width, -1);
        if (contourWidth != -1) {
            icon.contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_all_background_color, Integer.MIN_VALUE);
        if (backgroundColor != Integer.MIN_VALUE) {
            icon.backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_all_corner_radius, -1);
        if (cornerRadius != -1) {
            icon.roundedCornersPx(cornerRadius);
        }
        return icon;
    }

    public static IconicsDrawable readIconicsTextViewStart(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_start_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsTextView_iiv_start_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_start_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_start_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_start_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsTextViewTop(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_top_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsTextView_iiv_top_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_top_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_top_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_top_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsTextViewEnd(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_end_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsTextView_iiv_end_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_end_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_end_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_end_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsTextViewBottom(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsTextView_iiv_bottom_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsTextView_iiv_bottom_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsTextView_iiv_bottom_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsTextView_iiv_bottom_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }
    //endregion

    //region IconicsCompoundButton
    public static void readIconicsCompoundButton(Context ctx, TypedArray a, CheckableIconBundle icon) {
        //obtaining attributes for Checked icon state
        icon.mCheckedIconBundle = readIconicsCompoundButtonChecked(ctx, a, icon.mCheckedIconBundle);

        //obtaining attributes for Unchecked icon state
        icon.mUncheckedIconBundle = readIconicsCompoundButtonUnchecked(ctx, a, icon.mUncheckedIconBundle);
    }

    public static IconicsDrawable readIconicsCompoundButtonChecked(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsCompoundButton_iiv_checked_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsCompoundButtonUnchecked(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsCompoundButton_iiv_unchecked_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCompoundButton_iiv_unchecked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCompoundButton_iiv_unchecked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }
    //endregion

    //region IconicsCheckableTextView

    /**
     * Attributes priority:
     * <p>
     * Attributes with mark 'all' < attributes with some else mark ('start', 'top' etc)<br>
     * Working like as 'style' xml-attribute - local overrides global
     * <p>
     * <b>IMPORTANT TRICK</b>
     * <p>
     * For overriding some of attributes to default use resources with prefix 'default_'
     */
    public static void readIconicsCheckableTextView(Context ctx, TypedArray a, CompoundIconsBundle bundle) {
        //obtaining attributes for all icons
        IconicsDrawable allIconBundle = readIconicsCheckableTextViewAll(a, new IconicsDrawable(ctx));

        //obtaining attributes for start icons
        bundle.mStartIconBundle = readIconicsCheckableTextViewStart(ctx, a, allIconBundle);

        //obtaining attributes for top icons
        bundle.mTopIconBundle = readIconicsCheckableTextViewTop(ctx, a, allIconBundle);

        //obtaining attributes for end icons
        bundle.mEndIconBundle = readIconicsCheckableTextViewEnd(ctx, a, allIconBundle);

        //obtaining attributes for bottom icons
        bundle.mBottomIconBundle = readIconicsCheckableTextViewBottom(ctx, a, allIconBundle);
    }

    public static IconicsDrawable readIconicsCheckableTextViewAll(TypedArray a, IconicsDrawable icon) {
        String i = a.getString(R.styleable.IconicsCheckableTextView_iiv_all_checked_icon);
        if (i != null) {
            icon.icon(i);
        }
        int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_color, Integer.MIN_VALUE);
        if (color != Integer.MIN_VALUE) {
            icon.color(color);
        }
        int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_size, -1);
        if (size != -1) {
            icon.sizePx(size);
        }
        int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_padding, -1);
        if (padding != -1) {
            icon.paddingPx(padding);
        }
        int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_color, Integer.MIN_VALUE);
        if (contourColor != Integer.MIN_VALUE) {
            icon.contourColor(contourColor);
        }
        int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_contour_width, -1);
        if (contourWidth != -1) {
            icon.contourWidthPx(contourWidth);
        }
        int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_all_checked_background_color, Integer.MIN_VALUE);
        if (backgroundColor != Integer.MIN_VALUE) {
            icon.backgroundColor(backgroundColor);
        }
        int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_all_checked_corner_radius, -1);
        if (cornerRadius != -1) {
            icon.roundedCornersPx(cornerRadius);
        }
        return icon;
    }

    public static IconicsDrawable readIconicsCheckableTextViewStart(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_start_checked_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_start_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_start_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsCheckableTextViewTop(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_top_checked_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_top_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_top_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsCheckableTextViewEnd(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_end_checked_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_end_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_end_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }

    public static IconicsDrawable readIconicsCheckableTextViewBottom(Context ctx, TypedArray a, IconicsDrawable icon) {
        String i = Utils.getString(a, R.styleable.IconicsCheckableTextView_iiv_all_checked_icon, R.styleable.IconicsCheckableTextView_iiv_bottom_checked_icon);
        if (i != null || (icon != null && icon.getIcon() != null)) {
            if (icon == null) {
                icon = new IconicsDrawable(ctx, i);
            } else {
                icon = icon.clone();
                if (i != null) {
                    icon.icon(i);
                }
            }
            int color = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_color, Integer.MIN_VALUE);
            if (color != Integer.MIN_VALUE) {
                icon.color(color);
            }
            int size = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_size, -1);
            if (size != -1) {
                icon.sizePx(size);
            }
            int padding = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_padding, -1);
            if (padding != -1) {
                icon.paddingPx(padding);
            }
            int contourColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_color, Integer.MIN_VALUE);
            if (contourColor != Integer.MIN_VALUE) {
                icon.contourColor(contourColor);
            }
            int contourWidth = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_contour_width, -1);
            if (contourWidth != -1) {
                icon.contourWidthPx(contourWidth);
            }
            int backgroundColor = a.getColor(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_background_color, Integer.MIN_VALUE);
            if (backgroundColor != Integer.MIN_VALUE) {
                icon.backgroundColor(backgroundColor);
            }
            int cornerRadius = a.getDimensionPixelSize(R.styleable.IconicsCheckableTextView_iiv_bottom_checked_corner_radius, -1);
            if (cornerRadius != -1) {
                icon.roundedCornersPx(cornerRadius);
            }
        }
        return icon;
    }
    //endregion
}
