package org.upstartcommerce.avataxsdk.client.pekko

import org.apache.pekko.http.scaladsl.marshalling._
import org.apache.pekko.http.scaladsl.model.MediaTypes.`application/json`
import org.apache.pekko.http.scaladsl.model.{ContentTypeRange, MediaType, MessageEntity}
import org.apache.pekko.http.scaladsl.unmarshalling._
import org.apache.pekko.util.ByteString
import play.api.libs.json.{JsError, Json, Reads, Writes}

object PlayJsonSupport {

  final val mediaTypes: Seq[MediaType.WithFixedCharset] = List(`application/json`)

  final val contentTypes: Seq[ContentTypeRange] = mediaTypes.map(ContentTypeRange.apply)

  final val jsonStringMarshaller: Marshaller[String, MessageEntity] =
    Marshaller.oneOf(mediaTypes: _*)(Marshaller.stringMarshaller)

  final val jsonStringUnmarshaller: FromEntityUnmarshaller[String] =
    Unmarshaller.byteStringUnmarshaller.forContentTypes(contentTypes: _*).mapWithCharset {
      case (ByteString.empty, _) => throw Unmarshaller.NoContentException
      case (data, charset) => data.decodeString(charset.nioCharset.name)
    }

  implicit def marshaller[A](implicit writes: Writes[A]): ToEntityMarshaller[A] =
    jsonStringMarshaller.compose(Json.prettyPrint).compose(writes.writes)

  implicit def unmarshaller[A](implicit reads: Reads[A]): FromEntityUnmarshaller[A] =
    jsonStringUnmarshaller.map { data =>
      reads.reads(Json.parse(data)).recoverTotal(e => throw new IllegalArgumentException(JsError.toJson(e).toString()))
    }

}
