package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new Parcelable.Creator<CalendarConstraints>() {
        public CalendarConstraints createFromParcel(Parcel source) {
            return new CalendarConstraints((Month) source.readParcelable(Month.class.getClassLoader()), (Month) source.readParcelable(Month.class.getClassLoader()), (Month) source.readParcelable(Month.class.getClassLoader()), (DateValidator) source.readParcelable(DateValidator.class.getClassLoader()));
        }

        public CalendarConstraints[] newArray(int size) {
            return new CalendarConstraints[size];
        }
    };
    /* access modifiers changed from: private */
    public final Month end;
    private final int monthSpan;
    /* access modifiers changed from: private */
    public final Month openAt;
    /* access modifiers changed from: private */
    public final Month start;
    /* access modifiers changed from: private */
    public final DateValidator validator;
    private final int yearSpan;

    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    private CalendarConstraints(Month start2, Month end2, Month openAt2, DateValidator validator2) {
        this.start = start2;
        this.end = end2;
        this.openAt = openAt2;
        this.validator = validator2;
        if (start2.compareTo(openAt2) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        } else if (openAt2.compareTo(end2) <= 0) {
            this.monthSpan = start2.monthsUntil(end2) + 1;
            this.yearSpan = (end2.year - start2.year) + 1;
        } else {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isWithinBounds(long date) {
        if (this.start.getDay(1) <= date) {
            Month month = this.end;
            if (date <= month.getDay(month.daysInMonth)) {
                return true;
            }
        }
        return false;
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* access modifiers changed from: package-private */
    public Month getStart() {
        return this.start;
    }

    /* access modifiers changed from: package-private */
    public Month getEnd() {
        return this.end;
    }

    /* access modifiers changed from: package-private */
    public Month getOpenAt() {
        return this.openAt;
    }

    /* access modifiers changed from: package-private */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* access modifiers changed from: package-private */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints that = (CalendarConstraints) o;
        if (!this.start.equals(that.start) || !this.end.equals(that.end) || !this.openAt.equals(that.openAt) || !this.validator.equals(that.validator)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.start, 0);
        dest.writeParcelable(this.end, 0);
        dest.writeParcelable(this.openAt, 0);
        dest.writeParcelable(this.validator, 0);
    }

    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        private long end = DEFAULT_END;
        private Long openAt;
        private long start = DEFAULT_START;
        private DateValidator validator = DateValidatorPointForward.from(Long.MIN_VALUE);

        public Builder() {
        }

        Builder(CalendarConstraints clone) {
            this.start = clone.start.timeInMillis;
            this.end = clone.end.timeInMillis;
            this.openAt = Long.valueOf(clone.openAt.timeInMillis);
            this.validator = clone.validator;
        }

        public Builder setStart(long month) {
            this.start = month;
            return this;
        }

        public Builder setEnd(long month) {
            this.end = month;
            return this;
        }

        public Builder setOpenAt(long month) {
            this.openAt = Long.valueOf(month);
            return this;
        }

        public Builder setValidator(DateValidator validator2) {
            this.validator = validator2;
            return this;
        }

        public CalendarConstraints build() {
            if (this.openAt == null) {
                long today = MaterialDatePicker.thisMonthInUtcMilliseconds();
                long j = this.start;
                if (j <= today && today <= this.end) {
                    j = today;
                }
                this.openAt = Long.valueOf(j);
            }
            Bundle deepCopyBundle = new Bundle();
            deepCopyBundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            return new CalendarConstraints(Month.create(this.start), Month.create(this.end), Month.create(this.openAt.longValue()), (DateValidator) deepCopyBundle.getParcelable(DEEP_COPY_VALIDATOR_KEY));
        }
    }
}
