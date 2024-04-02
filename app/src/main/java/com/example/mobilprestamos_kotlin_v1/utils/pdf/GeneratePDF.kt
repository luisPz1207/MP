package com.example.mobilprestamos_kotlin_v1.utils.pdf

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.pdf.PdfDocument
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.mobilprestamos_kotlin_v1.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

fun GeneratePDF (context: Context, directory: File){
    val pageHeight = 1120
    val pageWidth = 792
    val pdfDocument = PdfDocument()
    val paint = Paint()
    val title = Paint()
    val myPageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
    val myPage = pdfDocument.startPage(myPageInfo)
    val canvas: Canvas = myPage.canvas
    val bitmap: Bitmap? = drawableToBitmap(context.resources.getDrawable(R.drawable.logo))
    val scaleBitmap: Bitmap? = Bitmap.createScaledBitmap(bitmap!!, 50, 50, false)

    /// TODO LOGO///
    canvas.drawBitmap(scaleBitmap!!, 40f, 40f, paint)

    //// TODO CABECERA ///
    title.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
    title.textSize = 20f
    title.color = ContextCompat.getColor(context, R.color.black)
    canvas.drawText("NewPrest", 120f, 80f, title)
    canvas.drawText("calle sarasota #40, sector Bella vista, Sto. Dgo.", 120f, 100f, title)
    canvas.drawText("Tel.: 809-784-1545", 120f, 120f, title)

    /// TODO DATOS CABECERA CON CLIENTE ///
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    title.color = ContextCompat.getColor(context, R.color.black)
    title.textSize = 20f
    title.textAlign = Paint.Align.LEFT
    canvas.drawText("Cliente  :", 80f, 160f, title)
    canvas.drawText("Cobrador :", 80f, 180f, title)
    canvas.drawText("N. de Prestamo:", 80f, 200f, title)

    canvas.drawText(
        "-----------------------------------------------------------------------------------------",
        80f, 220f, title
    )
    title.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
    canvas.drawText("RECIBO", 250f, 230f, title)
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    canvas.drawText(
        "-----------------------------------------------------------------------------------------",
        80f, 240f, title
    )

    ///// TODO DETALLE label///
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    title.color = ContextCompat.getColor(context, R.color.black)
    title.textSize = 20f
    title.textAlign = Paint.Align.LEFT
    canvas.drawText("Capital", 80f, 260f, title)
    canvas.drawText("Interes", 80f, 280f, title)
    canvas.drawText("Mora", 80f, 300f, title)
    canvas.drawText("Gasto de cierre", 80f, 320f, title)
    canvas.drawText(
        "-----------------------------------------------------------------------------------------",
        80f, 340f, title
    )
    canvas.drawText("TOTAL:", 80f, 360f, title)

    ///// TODO DETALLE values///
    title.typeface = Typeface.defaultFromStyle(Typeface.BOLD)
    title.color = ContextCompat.getColor(context, R.color.black)
    title.textSize = 20f
    title.textAlign = Paint.Align.RIGHT
    canvas.drawText("$5,000.00", 500f, 260f, title)
    canvas.drawText("$2,000.00", 500f, 280f, title)
    canvas.drawText("$0.00", 500f, 300f, title)
    canvas.drawText("$0.00", 500f, 320f, title)
    title.textSize = 25f
    canvas.drawText("$7,000.00", 500f, 360f, title)

    /// TODO FOOTER ///
    title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
    title.color = ContextCompat.getColor(context, R.color.black)
    title.textSize = 20f
    title.textAlign = Paint.Align.LEFT
    canvas.drawText("Metodo de Pago  :", 80f, 400f, title)
    canvas.drawText("Concepto :", 80f, 420f, title)
    canvas.drawText("N. de Prestamo:", 80f, 440f, title)


    canvas.drawText("PDF de Recibo de cobro de prueba", 396f, 560f, title)
    pdfDocument.finishPage(myPage)
    val file = File(directory, "sample.pdf")

    try {
        pdfDocument.writeTo(FileOutputStream(file))
        Toast.makeText(context, "PDF file generated successfylly", Toast.LENGTH_SHORT).show()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    pdfDocument.close()
}


fun drawableToBitmap(drawable: Drawable): Bitmap? {
    if (drawable is BitmapDrawable) {
        return drawable.bitmap
    }
    val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)
    return bitmap
}
