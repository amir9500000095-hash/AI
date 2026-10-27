package org.hamdel.pet

/**
 * Plain-language checks for testing the prototype with Android screen readers.
 * This helper intentionally uses native Kotlin strings and Android accessibility APIs only.
 */
internal object AccessibilityAudit {
    val checklist: List<String> = listOf(
        "TalkBack روشن باشد و همهٔ دکمه‌ها با نام روشن خوانده شوند.",
        "ترتیب پیمایش از عنوان به وضعیت و سپس دکمه‌های اصلی قابل پیش‌بینی باشد.",
        "پس از غذا دادن، تمیز کردن، بازی و خواب، پیام نتیجه اعلام شود.",
        "وضعیت گرسنگی، تمیزی، انرژی و خوشحالی به‌صورت متن قابل خواندن باشد.",
        "پیوندهای بخش دربارهٔ ما با TalkBack قابل انتخاب و باز شدن باشند.",
        "هیچ قابلیت مهمی فقط با رنگ، تصویر یا حرکت قابل تشخیص نباشد.",
        "برنامه بدون درخواست مجوزهای غیرضروری اجرا شود.",
        "پس از بستن و باز کردن دوبارهٔ برنامه، وضعیت ذخیره‌شده باقی بماند."
    )
}
