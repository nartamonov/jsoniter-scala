package com.github.plokhotnyuk.jsoniter_scala.benchmark

import com.avsystem.commons.serialization.{flatten, transientDefault}
import zio.json.jsonDiscriminator
import scala.collection.immutable.ArraySeq

object GeoJSON {
  @flatten("type")
  @jsonDiscriminator("type")
  sealed trait Geometry extends Product with Serializable

  @jsonDiscriminator("type")
  sealed trait SimpleGeometry extends Geometry

  case class Point(coordinates: (Double, Double)) extends SimpleGeometry

  case class MultiPoint(coordinates: ArraySeq[(Double, Double)]) extends SimpleGeometry

  case class LineString(coordinates: ArraySeq[(Double, Double)]) extends SimpleGeometry

  case class MultiLineString(coordinates: ArraySeq[ArraySeq[(Double, Double)]]) extends SimpleGeometry

  case class Polygon(coordinates: ArraySeq[ArraySeq[(Double, Double)]]) extends SimpleGeometry

  case class MultiPolygon(coordinates: ArraySeq[ArraySeq[ArraySeq[(Double, Double)]]]) extends SimpleGeometry

  case class GeometryCollection(geometries: ArraySeq[SimpleGeometry]) extends Geometry

  @flatten("type")
  @jsonDiscriminator("type")
  sealed trait GeoJSON extends Product with Serializable

  @jsonDiscriminator("type")
  sealed trait SimpleGeoJSON extends GeoJSON

  case class Feature(
    @transientDefault properties: Map[String, String] = Map.empty,
    geometry: Geometry,
    @transientDefault bbox: Option[(Double, Double, Double, Double)] = None) extends SimpleGeoJSON

  case class FeatureCollection(
    features: ArraySeq[SimpleGeoJSON],
    @transientDefault bbox: Option[(Double, Double, Double, Double)] = None) extends GeoJSON
}