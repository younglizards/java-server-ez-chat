package com.example.echoserver

import java.io.*
import java.net.ServerSocket

fun main(args: Array<String>) {

    try {
        val sk = ServerSocket(Integer.parseInt(args[0]))

        while (true) {

            val client = sk.accept()

            Thread().run {

                while (true) {

                    if (client.isClosed) {
                        break
                    }

                    val input = BufferedReader(InputStreamReader(client.getInputStream()))
                    val output = PrintWriter(OutputStreamWriter(client.getOutputStream()))

                    val data = input.readLine()
                    output.println(data)
                    output.flush()

                    System.out.println(data)
                }
            }
        }

    } catch (ioe: IOException) {
        ioe.printStackTrace()
        System.out.println(ioe)
    }
}