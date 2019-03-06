package ru.vetukov.wskotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket

class MainActivity : AppCompatActivity() {

    private lateinit var mTextView: TextView
    private lateinit var mCheckButton: Button

    private lateinit var mMyWebSocket: MyWebSocket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView       = findViewById(R.id.main_text)
        mCheckButton    = findViewById(R.id.main_button_submit)

        mMyWebSocket    = MyWebSocket()

        var client: OkHttpClient = OkHttpClient()

        var request: Request = Request
                                        .Builder()
                                        .url("ws://51.15.98.179:8000/ws")
                                        .build()

        var wc: WebSocket = WebSocket(request, mMyWebSocket)


        /*

        WebSocket ws = client.newWebSocket(request, wsc);


        wsc.getUser(ws);


        client.dispatcher().executorService().shutdown();*/

    }
}
