import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.AttributeSet
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.example.customview.MainActivity2

class CustomView(context: Context, attrs: AttributeSet? = null) : RelativeLayout(context){
    init {
        // Create a button programmatically
        val button = Button(context)
        button.text = "Click me"
        button.setBackgroundColor(Color.BLUE)
        button.setTextColor(Color.WHITE)

        val text1 = TextView(context)
        text1.setTextColor( Color.RED)
        text1.text = "Added text"


        // Set layout parameters for the button
        val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )
        params.addRule(RelativeLayout.ALIGN_PARENT_END)

        // Add the button to the layout
        addView(button, params)
        addView(text1)

        // Set a click listener for the button
        button.setOnClickListener {
            // Handle button click
            showToast("Button Clicked!")
            println("Buuton clicked!")
            var intent = Intent(context, MainActivity2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)

        }
    }

    // Function to show a toast message
    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}