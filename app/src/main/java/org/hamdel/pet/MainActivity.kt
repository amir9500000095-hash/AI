package org.hamdel.pet

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.view.Gravity
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var root: LinearLayout
    private lateinit var status: TextView
    private lateinit var stats: TextView
    private val prefs by lazy { getSharedPreferences("pet_state", MODE_PRIVATE) }
    private var hunger = 60
    private var clean = 75
    private var energy = 80
    private var joy = 70

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hunger = prefs.getInt("hunger", 60)
        clean = prefs.getInt("clean", 75)
        energy = prefs.getInt("energy", 80)
        joy = prefs.getInt("joy", 70)
        showHome()
    }

    private fun column(): LinearLayout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        layoutDirection = View.LAYOUT_DIRECTION_LOCALE
        setPadding(20, 20, 20, 24)
    }

    private fun title(value: String) = TextView(this).apply {
        text = value
        textSize = 27f
        typeface = Typeface.DEFAULT_BOLD
        gravity = Gravity.CENTER
        contentDescription = value
        setPadding(8, 16, 8, 16)
    }

    private fun text(value: String) = TextView(this).apply {
        text = value
        textSize = 18f
        gravity = Gravity.CENTER
        setPadding(8, 10, 8, 10)
    }

    private fun action(label: String, hint: String = label, run: () -> Unit) = Button(this).apply {
        text = label
        contentDescription = hint
        isAllCaps = false
        textSize = 18f
        minHeight = 56
        setOnClickListener { run() }
    }

    private fun install(view: View) {
        val scroll = ScrollView(this)
        scroll.isFillViewport = true
        scroll.addView(view)
        setContentView(scroll)
    }

    private fun showHome() {
        root = column()
        root.addView(title("همدل‌پت"))
        root.addView(text("دوست کوچولوی مجازی تو"))
        root.addView(text("🐾 حیوانک همدل 🐾"))
        stats = text("")
        root.addView(stats)
        status = text("خوش اومدی! یکی از گزینه‌ها رو انتخاب کن.")
        status.accessibilityLiveRegion = View.ACCESSIBILITY_LIVE_REGION_POLITE
        root.addView(status)
        root.addView(action("غذا دادن", "غذا دادن به حیوانک") {
            hunger = (hunger + 20).coerceAtMost(100)
            joy = (joy + 3).coerceAtMost(100)
            update("نوم نوم! حیوانکت غذا خورد.")
        })
        root.addView(action("تمیز کردن", "تمیز کردن حیوانک") {
            clean = (clean + 25).coerceAtMost(100)
            update("حیوانکت تمیزتر و مرتب‌تر شد.")
        })
        root.addView(action("بازی کردن", "بازی کردن با حیوانک") {
            joy = (joy + 15).coerceAtMost(100)
            energy = (energy - 10).coerceAtLeast(0)
            hunger = (hunger - 5).coerceAtLeast(0)
            update("چه بازی خوبی! حیوانکت خوشحال‌تر شد.")
        })
        root.addView(action("وقت خوابه", "فرستادن حیوانک برای استراحت") {
            energy = (energy + 25).coerceAtMost(100)
            update("حیوانکت استراحت کرد و انرژی گرفت.")
        })
        root.addView(action("دربارهٔ ما", "خواندن دربارهٔ تیم همدل") { showAbout() })
        root.addView(action("راهنمای صفحه‌خوان", "راهنمای استفاده با TalkBack") {
            announce("با حرکت پیمایشی TalkBack بین گزینه‌ها حرکت کن. دکمه‌ها نام مشخص دارند و نتیجهٔ هر کار اعلام می‌شود.")
        })
        install(root)
        update("سلام! حیوانکت منتظرته.")
    }

    private fun update(message: String) {
        stats.text = "گرسنگی: $hunger از ۱۰۰\nتمیزی: $clean از ۱۰۰\nانرژی: $energy از ۱۰۰\nخوشحالی: $joy از ۱۰۰"
        announce(message)
        prefs.edit().putInt("hunger", hunger).putInt("clean", clean)
            .putInt("energy", energy).putInt("joy", joy).apply()
    }

    private fun announce(message: String) {
        status.text = message
        status.sendAccessibilityEvent(AccessibilityEvent.TYPE_ANNOUNCEMENT)
    }

    private fun showAbout() {
        val page = column()
        page.addView(title("دربارهٔ ما؛ تیم همدل"))
        val copy = """
درود رفیق! خوش اومدی به بخش دربارهٔ ما. اینجا می‌خوایم راحت و روشن بگیم این برنامه چیه، چرا شروع شده و چه چیزهایی هنوز باید بهتر بشن.

همدل‌پت یک پروژهٔ مستقل از طرف تیم همدله. ایده‌اش از یک خواستهٔ مهم اومده: سرگرمی‌های دیجیتال باید برای نابینایان هم قابل استفاده باشن. کسی که از TalkBack استفاده می‌کنه هم باید بتونه گزینه‌ها رو پیدا کنه، بفهمه هر گزینه چه کاری انجام می‌ده و نتیجهٔ انتخابش رو بشنوه؛ نه اینکه مجبور باشه از روی تصویر یا رنگ حدس بزنه.

اسم تیم همدل برای ما یادآور اینه که دسترس‌پذیری فقط یک شعار قشنگ نیست. باید کنترل‌ها واقعاً با صفحه‌خوان کار کنن، متن‌ها روشن باشن، ترتیب پیمایش قابل پیش‌بینی باشه و پیام‌های برنامه اطلاعات مفید بدن. این کار با آزمایش، شنیدن بازخورد و اصلاح مداوم بهتر می‌شه.

یه موضوع رو هم از اول شفاف بگیم: این برنامه نسخهٔ اصلی Pou نیست و تیم همدل سازندهٔ Pou نیست. Pou بازی حیوان خانگی مجازی‌ایه که سازنده و صاحبان حقوق خودش رو داره. این پروژه مستقل نوشته شده و ادعای وابستگی یا تأیید رسمی از طرف سازندگان Pou نداره. فایل APK که برای بررسی فرستاده شده، بستهٔ کامپایل‌شده است؛ کد منبع اصلی همراهش نیست. به همین خاطر، از روی همین فایل به‌تنهایی نمی‌شه تضمین کرد که همهٔ قابلیت‌ها، ظاهر، مینی‌گیم‌ها و رفتارهای بازی اصلی بدون هیچ تغییری بازسازی بشن.

می‌دونیم صداهای آشنا بخش مهمی از خاطرهٔ یک بازی هستن. نمی‌خوایم صدای تازه‌ای رو به اسم صدای اصلی معرفی کنیم یا قول بدیم تمام صداهای بازی اصلی به‌درستی قابل استفاده‌اند. استفاده از منابع اختصاصی باید با مجوز روشن و بررسی فنی انجام بشه. این نمونه فعلاً از متن‌های فارسی و اعلام‌های دسترس‌پذیری اندروید استفاده می‌کنه.

این نسخه یک نمونهٔ اولیه است، نه یک بازی کامل تجاری. فعلاً چند تعامل ساده برای غذا دادن، تمیز کردن، بازی و خواب دارد و وضعیت را روی دستگاه نگه می‌دارد. فروشگاه، لباس‌ها، مینی‌گیم‌های اصلی، انیمیشن‌های کامل، حساب کاربری و تمام قابلیت‌های Pou در این نسخه پیاده‌سازی نشده‌اند. ترجیح می‌دیم این محدودیت‌ها رو صادقانه بگیم تا انتظار اشتباه ایجاد نشه.

برای ما مهمه که دکمه‌ها اسم قابل فهم داشته باشن و بعد از انتخاب، نتیجه اعلام بشه. با این حال، هیچ پیاده‌سازی‌ای صرفاً به خاطر داشتن برچسب «دسترس‌پذیر» کامل نمی‌شه؛ باید با TalkBack واقعی آزمایش بشه. اگر کنترل‌ها درست خوانده نمی‌شن، ترتیب پیمایش گیج‌کننده است یا پیام‌ها بیش از حد تکرار می‌شن، گزارش دقیق شما به بهتر شدن برنامه کمک می‌کنه.

اگر خواستی مشکل گزارش کنی، مدل گوشی، نسخهٔ اندروید، نام صفحه‌خوان و مراحل رسیدن به مشکل رو بنویس. لطفاً رمز، اطلاعات خصوصی یا داده‌های حساس رو در گزارش عمومی قرار نده. لازم نیست حتماً برنامه‌نویس باشی؛ توصیف روشن تجربهٔ واقعی هم ارزش زیادی داره.

در مورد امنیت هم وعدهٔ غیرواقعی نمی‌دیم. هیچ‌کس نمی‌تونه تضمین کنه Play Protect هیچ‌وقت دربارهٔ یک APK هشدار نده. فایل آزمایشی با امضای debug برای تست ساخته می‌شه و این امضا به معنی تأیید رسمی Google Play یا اثبات هویت سازنده نیست. برای انتشار رسمی باید کلید انتشار جداگانه، امن و تحت کنترل صاحب پروژه مدیریت بشه.

می‌خوایم این پروژه با مشارکت جامعهٔ فارسی‌زبان رشد کنه. پیشنهادهای محترمانه، گزارش باگ و تجربهٔ استفاده با صفحه‌خوان کمک می‌کنن مسیر توسعه واقعی‌تر بشه. هدف این نیست که فقط یک برنامه بسازیم و اسم دسترس‌پذیری روش بذاریم؛ هدف اینه که قدم‌به‌قدم بفهمیم کجا کار می‌کنه و کجا هنوز مانع وجود داره.

ممنون که وقت گذاشتی و این توضیحات رو خوندی. همدل‌پت از یک نمونهٔ کوچیک شروع شده و آینده‌اش به آزمایش، اصلاح و مشارکت بستگی داره.

با رفاقت،
تیم همدل
        """.trimIndent()
        val paragraph = TextView(this).apply {
            text = copy
            textSize = 17f
            gravity = Gravity.START
            setPadding(8, 12, 8, 12)
            textDirection = View.TEXT_DIRECTION_LOCALE
        }
        page.addView(paragraph)
        val links = TextView(this).apply {
            textSize = 18f
            setPadding(8, 16, 8, 16)
            val items = listOf(
                "وب‌سایت رسمی Pou" to "https://www.pou.me",
                "مخزن پروژهٔ همدل‌پت" to "https://github.com/amir9500000095-hash/AI",
                "گزارش باگ یا پیشنهاد" to "https://github.com/amir9500000095-hash/AI/issues"
            )
            val builder = SpannableString(items.joinToString("\n") { it.first })
            var offset = 0
            items.forEach { item ->
                val start = offset
                val end = start + item.first.length
                builder.setSpan(object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(item.second)))
                    }
                }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                offset = end + 1
            }
            text = builder
            movementMethod = android.text.method.LinkMovementMethod.getInstance()
        }
        page.addView(links)
        page.addView(action("بازگشت به صفحهٔ اصلی", "بازگشت به بازی") { showHome() })
        install(page)
    }
}
