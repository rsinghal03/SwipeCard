package com.example.swipecard

import com.example.swipecard.data.model.Data
import com.example.swipecard.data.model.Response
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

class MockDataProvider {

    companion object {

        fun getListOfDataSuccessResponse(): Response {

            return Response(getListOfData())
        }

        fun getListOfData(): List<Data> {
          return jacksonObjectMapper().readValue<List<Data>>(jsonString)
        }
    }
}

val jsonString = """[
        {
            "id": "1",
            "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        },
        {
            "id": "2",
            "text": "Felis donec et odio pellentesque diam volutpat commodo sed. Non arcu risus quis varius quam quisque. Nibh nisl condimentum id venenatis a condimentum vitae. Vel pharetra vel turpis nunc eget. "
        },
        {
            "id": "3",
            "text": "Volutpat sed cras ornare arcu dui vivamus arcu felis bibendum. Lobortis mattis aliquam faucibus purus in. Aliquam sem fringilla ut morbi tincidunt augue interdum."
        },
        {
            "id": "4",
            "text": "Elit scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique. Bibendum at varius vel pharetra vel turpis nunc. Pellentesque sit amet porttitor eget dolor morbi non."
        },
        {
            "id": "5",
            "text": "Urna condimentum mattis pellentesque id. Ac tincidunt vitae semper quis. Massa tincidunt dui ut ornare lectus sit amet. Netus et malesuada fames ac turpis. Nulla facilisi cras fermentum odio eu feugiat pretium nibh."
        },
        {
            "id": "6",
            "text": "Tincidunt id aliquet risus feugiat in ante. Id donec ultrices tincidunt arcu non sodales neque sodales. Turpis massa tincidunt dui ut ornare lectus sit amet est. At ultrices mi tempus imperdiet nulla malesuada pellentesque elit."
        },
        {
            "id": "7",
            "text": "Fermentum posuere urna nec tincidunt praesent semper feugiat. Nulla facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum. At auctor urna nunc id cursus metus aliquam eleifend mi."
        },
        {
            "id": "8",
            "text": "Quisque sagittis purus sit amet volutpat consequat mauris nunc congue. Malesuada fames ac turpis egestas sed. Volutpat ac tincidunt vitae semper. Aliquam nulla facilisi cras fermentum."
        }
    ]
"""
