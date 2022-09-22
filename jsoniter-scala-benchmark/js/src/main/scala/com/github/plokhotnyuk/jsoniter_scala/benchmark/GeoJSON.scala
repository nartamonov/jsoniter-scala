package com.github.plokhotnyuk.jsoniter_scala.benchmark

import com.avsystem.commons.serialization.{flatten, transientDefault}
import zio.json.jsonDiscriminator
import scala.collection.immutable.List

object GeoJSON {
  @flatten("type")
  @jsonDiscriminator("type")
  sealed trait Geometry extends Product with Serializable

  @jsonDiscriminator("type")
  sealed trait SimpleGeometry extends Geometry

  case class Point(coordinates: (Double, Double)) extends SimpleGeometry

  case class MultiPoint(coordinates: List[(Double, Double)]) extends SimpleGeometry

  case class LineString(coordinates: List[(Double, Double)]) extends SimpleGeometry

  case class MultiLineString(coordinates: List[List[(Double, Double)]]) extends SimpleGeometry

  case class Polygon(coordinates: List[List[(Double, Double)]]) extends SimpleGeometry

  case class MultiPolygon(coordinates: List[List[List[(Double, Double)]]]) extends SimpleGeometry

  case class GeometryCollection(geometries: List[SimpleGeometry]) extends Geometry

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
    features: List[SimpleGeoJSON],
    @transientDefault bbox: Option[(Double, Double, Double, Double)] = None) extends GeoJSON
}