package com.mu.muapp.utils.gson

import android.net.ParseException
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import java.lang.reflect.Type


class DateDeserializer : JsonDeserializer<DateTime> {
    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, arg1: Type, arg2: JsonDeserializationContext): DateTime {
        val date = element.asString
        val df = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ")
        try {
            val temp = df.withOffsetParsed().parseDateTime(date);
            return temp
        } catch (e: ParseException) {
            println("yep - Failed to parse Date due to:" + e)
            return df.withOffsetParsed().parseDateTime("1970-01-01")
        }

    }
}