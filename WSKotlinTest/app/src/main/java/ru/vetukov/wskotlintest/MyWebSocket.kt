package ru.vetukov.wskotlintest

import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

open class MyWebSocket : WebSocketListener() {

    override fun onOpen(webSocket: WebSocket, response: Response) {
        webSocket.send("{\"method\":\"hello\"}")
    }

    fun getUser(webSocket: WebSocket) {
        webSocket.send("{\"method\": \"get_client\", \"client_id\" : \"234234\"}")
    }

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
    }

}
