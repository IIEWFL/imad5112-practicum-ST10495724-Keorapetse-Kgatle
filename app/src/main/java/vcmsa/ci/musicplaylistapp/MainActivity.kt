package vcmsa.ci.musicplaylistapp

import android.R.attr.rating
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Comment
//Keorapetse Kgatle
//St10495724
class MainActivity : AppCompatActivity() {
    //setting my array
    companion object {
        val songs = arrayListOf<String>()
        val artists = arrayListOf<String>()
        val ratings = arrayListOf<Int>()
        val comments = arrayListOf<String>()
    }
//Declaration
    private lateinit var songInput: EditText
    private lateinit var artistInput: EditText
    private lateinit var ratingInput: EditText
    private lateinit var commentInput: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnDetailedView: Button
    private lateinit var btnExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing
        songInput = findViewById(R.id.song)
        artistInput = findViewById(R.id.artistName)
        ratingInput = findViewById(R.id.ratings)
        commentInput = findViewById(R.id.comment)
        btnAdd = findViewById(R.id.btnAdd)
        btnDetailedView = findViewById(R.id.btnDetailedViewScreen)
        btnExit = findViewById(R.id.btnExit)

        // set on click listener for btnAdd
        btnAdd.setOnClickListener {
            val song = songInput.text.toString()
            val artist = artistInput.text.toString()
            val rating = ratingInput.text.toString().toIntOrNull()
            val comment = commentInput.text.toString()

            //Error Handling incase the user enters a number smaller than 1 or more than 5
            if (song.isBlank() || artist.isBlank() || rating == null || rating !in 1..5) {
                Toast.makeText(this, "Please enter valid details. Rating must be between 1 and 5.", Toast.LENGTH_SHORT).show()
            } else {
                songs.add(song)
                artists.add(artist)
                ratings.add(rating)
                comments.add(comment)
                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()

                songInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            }
        }

        // set on click listener for the btnDetailedView ...Takes you to a different Screen
        btnDetailedView.setOnClickListener {
            startActivity(Intent(this, Detailed_screen::class.java))
        }

        // To exit the app
        btnExit.setOnClickListener {
            finish()
        }
    }
}

//code Attribution
//This method was taken from stack overflow
//https://stackoverflow.com/posts/31366229/revisions
//Lars Blumberg
//https://stackoverflow.com/users/543875/lars-blumberg

//code Attribution
//This method was taken from stack overflow
//https://stackoverflow.com/questions/63220806/how-to-keep-imageview-going-offscreen-kotlin
//Jenea Vranceanu
//https://stackoverflow.com/users/7210237/jenea-vranceanu

//code Attribution
//This method was taken from stack overflow
//https://stackoverflow.com/questions/78206079/how-to-declare-kotlin-compiler-extension-version-using-version-catalog-file
//Lars Blumberg
//https://stackoverflow.com/users/543875/lars-blumberg//Lars Blumberg