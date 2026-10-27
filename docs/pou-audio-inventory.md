# Pou APK — فهرست فنی منابع صوتی

این گزارش بر اساس بررسی محلی فایل `Pou_v1.4.139.apk` تهیه شده است. فایل‌های صوتی در این گزارش کپی یا منتشر نمی‌شوند؛ فقط نام داخلی، قالب و مدت تقریبی ثبت شده تا مرحلهٔ شناسایی و دسترس‌پذیری قابل پیگیری باشد.

## خلاصه

- تعداد فایل‌های صوتی با پسوند شناخته‌شده: 63
- MP3: 25 فایل
- OGG/Vorbis: 38 فایل
- مدت‌ها با `ffprobe` خوانده شده‌اند.
- نام‌های کوتاه و مبهم فایل‌ها، به‌تنهایی نشان نمی‌دهند هر صدا مربوط به کدام کنش یا صفحه است.
- پیش از استفادهٔ مجدد از این منابع در نسخه‌ای دیگر، باید مجوز استفاده و رابطهٔ هر فایل با رویداد داخل بازی روشن باشد.

## فهرست

| فایل | قالب | مدت (ثانیه) |
|---|---|---:|
| 0R.mp3 | MP3 | 34.325 |
| 2N.ogg | OGG/Vorbis | 0.567 |
| 2S.mp3 | MP3 | 0.366 |
| 3_.mp3 | MP3 | 0.444 |
| 5N.ogg | OGG/Vorbis | 0.146 |
| 79.ogg | OGG/Vorbis | 0.903 |
| 8P.ogg | OGG/Vorbis | 0.480 |
| 9L.ogg | OGG/Vorbis | 2.256 |
| 9e.ogg | OGG/Vorbis | 0.420 |
| BU.ogg | OGG/Vorbis | 0.291 |
| C5.ogg | OGG/Vorbis | 0.549 |
| Cr.mp3 | MP3 | 0.627 |
| DB.mp3 | MP3 | 0.313 |
| EK.ogg | OGG/Vorbis | 0.455 |
| FE.mp3 | MP3 | 43.677 |
| Gr.ogg | OGG/Vorbis | 1.980 |
| Ib.mp3 | MP3 | 38.296 |
| Ic.mp3 | MP3 | 0.313 |
| J8.ogg | OGG/Vorbis | 1.124 |
| Ji.mp3 | MP3 | 53.394 |
| MP.mp3 | MP3 | 30.746 |
| MY.ogg | OGG/Vorbis | 0.373 |
| Ns.mp3 | MP3 | 0.522 |
| OH.ogg | OGG/Vorbis | 0.334 |
| P8.ogg | OGG/Vorbis | 0.561 |
| PK.ogg | OGG/Vorbis | 0.334 |
| Q8.mp3 | MP3 | 49.424 |
| RM.ogg | OGG/Vorbis | 0.268 |
| Rc.ogg | OGG/Vorbis | 0.446 |
| SU.ogg | OGG/Vorbis | 0.271 |
| Uq.mp3 | MP3 | 0.261 |
| WN.ogg | OGG/Vorbis | 0.244 |
| Wx.mp3 | MP3 | 27.481 |
| YQ.ogg | OGG/Vorbis | 0.110 |
| Yf.ogg | OGG/Vorbis | 1.661 |
| Z0.ogg | OGG/Vorbis | 1.208 |
| Zo.mp3 | MP3 | 38.452 |
| aY.mp3 | MP3 | 0.313 |
| bG.ogg | OGG/Vorbis | 1.541 |
| bl.mp3 | MP3 | 28.918 |
| cU.ogg | OGG/Vorbis | 1.541 |
| cZ.ogg | OGG/Vorbis | 1.045 |
| co.mp3 | MP3 | 19.827 |
| eb.mp3 | MP3 | 0.313 |
| f3.ogg | OGG/Vorbis | 0.675 |
| g5.mp3 | MP3 | 0.131 |
| gw.ogg | OGG/Vorbis | 0.880 |
| hl.ogg | OGG/Vorbis | 1.519 |
| ip.ogg | OGG/Vorbis | 0.453 |
| j_.mp3 | MP3 | 36.049 |
| jr.ogg | OGG/Vorbis | 0.252 |
| n1.ogg | OGG/Vorbis | 0.522 |
| ov.mp3 | MP3 | 24.059 |
| pn.mp3 | MP3 | 38.478 |
| qL.ogg | OGG/Vorbis | 0.780 |
| rQ.mp3 | MP3 | 0.340 |
| rk.ogg | OGG/Vorbis | 1.022 |
| tW.mp3 | MP3 | 0.575 |
| ue.ogg | OGG/Vorbis | 1.045 |
| y4.ogg | OGG/Vorbis | 0.653 |
| z-.ogg | OGG/Vorbis | 1.004 |
| z2.ogg | OGG/Vorbis | 0.583 |
| zG.ogg | OGG/Vorbis | 0.946 |

## گام بعدی

1. بررسی Manifest برای استخراج package name، نسخه و مجوزهای درخواست‌شده.
2. تعیین امضای فعلی APK و مقایسهٔ گواهی با منبعی که فایل از آن آمده است.
3. شناسایی منابع صوتی بر اساس شنیدن و بررسی ارجاع‌های کد، بدون حدس زدن از روی اسم فایل.
4. بررسی ساختار رابط و اینکه آیا کنترل‌های اصلی از APIهای استاندارد Android استفاده می‌کنند یا نه.
5. آزمایش TalkBack و ثبت موانع قابل بازتولید قبل از هرگونه تغییر.

این فهرست فقط موجودی صوتی را ثبت می‌کند؛ به معنی استخراج کامل محتوای برنامه یا آماده بودن نسخهٔ دسترس‌پذیر نیست.
