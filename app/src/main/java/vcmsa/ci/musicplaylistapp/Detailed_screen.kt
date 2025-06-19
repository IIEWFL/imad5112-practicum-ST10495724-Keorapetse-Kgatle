package vcmsa.ci.musicplaylistapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Detailed_screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_screen)
        //initializing
        val songList= findViewById<TextView>(R.id.songList)
        val Average = findViewById<TextView>(R.id.Average)
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnAverage = findViewById<Button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnReturn)

        //Displaying the users input
        btnDisplay.setOnClickListener {
            val output = StringBuilder()
            for (i in MainActivity.songs.indices) {
                output.append(" ${MainActivity.songs[i]} - ${MainActivity.artists[i]} (Rating: ${MainActivity.ratings[i]})\n")
                output.append(" ${MainActivity.comments[i]}\n\n")
            }
            songList.text = output.toString()
        }
             //calculating the average
        btnAverage.setOnClickListener {
            //error handling in case ratings Input is empty
            if (MainActivity.ratings.isEmpty()) {
                Average.text = "No ratings yet!"
            } else {
                val average = MainActivity.ratings.sum().toDouble() / MainActivity.ratings.size
               Average.text = "Average Rating: %.2f".format(average)
            }
        }
          //back to main screen
        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}