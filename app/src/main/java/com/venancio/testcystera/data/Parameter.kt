package com.venancio.testcystera.data

data class Parameter (val Parametro:String)

data class Validacoordenadas(
        val formatted : String,
        val lat : String,
        val lng : String,
        val username : String,
        val style : String
)
data class Usuario (

        val EnroladoMBSS : Boolean,
        val TemplateMBSS : String,
        val EnroladoFacial : Boolean,
        val TemplateFacial : String,
        val TemplateSmartBio : String,
        val IdCliente : String,
        val NumeroDocumento : String,
        val PrimerApellido : String,
        val SegundoApellido : String,
        val PrimerNombre : String,
        val SegundoNombre : String,
        val NombreCompleto : String,
        val Sexo : String,
        val FechaNacimiento : String,
        val RH : String,
        val VersionCedula : String,
        val TipoDedo1 : String,
        val NumeroTarjeta : String,
        val FechaCreacion : String,
        val FechaExpiracion : String,
        val Nombres : String,
        val Apellidos : String,
        val Codigo : String,
        val Nacionalidad : String,
        val Autoridad : String,
        val Vigente : Boolean
)data class JsonRespuestaUser (

        val Usuario : Usuario,
        val OperacionExitosa : Boolean,
        val Mensaje:String,
        val CodigoError : Int
)

data class JsonRespuestaBiometric (

        val ListaBiometricos :  List<ListaBiometricos>,
        val OperacionExitosa : Boolean,
        val Mensaje:String,
        val CodigoError : Int
)
data class ListaBiometricos(
        val Id:String,
        val Serial:String

)

data class Objsenddata(
        val IdCliente:Int,
        val ProcesoId:String,
        val NumeroHuellas:String,
        val FingerNumber:String,
        val Captura:String,
        var MinuciaData:String?=null,
        var MinuciaFormato:String?=null,
        var CompraAdicional:Boolean?=null
)

data class RespuestaBiometric  constructor(
        val OperacionExitosa:Boolean,
        val code:String,
        val codeDescription:String,
        val message:String,
        val fingerprintResult:String


)

data class Morphodevices(
        val IdOperacion:Int,
        val BarCodeBase64:String,
        val IdentificadorConsumidor:String,
        val IdentificadorProceso:String,
        val ImageKey:String,
        var NumeroDocumento:String?=null,
        val DeviceUUID:String
)


