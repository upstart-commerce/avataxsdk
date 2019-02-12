package org.upstartcommerce.avataxsdk.core.data.models
import java.sql.Date
import org.upstartcommerce.avataxsdk.core.data.enums._

final case class ParameterModel(id:Option[Long] = None, category:Option[String] = None, name:Option[String] = None, dataType:Option[String] = None, helpText:Option[String] = None, serviceTypes:List[String] = List.empty, prompt:Option[String] = None, regularExpression:Option[String] = None, label:Option[String] = None, helpUrl:Option[String] = None, attributeType:Option[String] = None, values:List[String] = List.empty, measurementType:Option[String] = None) {
  def withId(value:Long):ParameterModel = copy(id = Some(value))
  def withCategory(value:String):ParameterModel = copy(category = Some(value))
  def withName(value:String):ParameterModel = copy(name = Some(value))
  def withDataType(value:String):ParameterModel = copy(dataType = Some(value))
  def withHelpText(value:String):ParameterModel = copy(helpText = Some(value))
  def withServiceTypes(value:List[String]):ParameterModel = copy(serviceTypes = value)
  def withPrompt(value:String):ParameterModel = copy(prompt = Some(value))
  def withRegularExpression(value:String):ParameterModel = copy(regularExpression = Some(value))
  def withLabel(value:String):ParameterModel = copy(label = Some(value))
  def withHelpUrl(value:String):ParameterModel = copy(helpUrl = Some(value))
  def withAttributeType(value:String):ParameterModel = copy(attributeType = Some(value))
  def withValues(value:List[String]):ParameterModel = copy(values = value)
  def withMeasurementType(value:String):ParameterModel = copy(measurementType = Some(value))
}
  