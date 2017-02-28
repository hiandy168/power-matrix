




com.matrix.pojo.entity 直接与之对应的是每一张数据库中的表
	McUserInfo

com.matrix.pojo.dto 数据传输模型。请求中如果包含entity之外的字段则使用dto
	McUserInfoDto

com.matrix.pojo.view 返回数据模型。多表联查返回的结果集通常是以一个联合视图的形式反馈给service层。
	McUserInfoView
	
com.matrix.pojo.input api相关内容中的输入参数描述
	McUserInfoInput

com.matrix.pojo.result api相关内容中的输出参数描述
	McUserInfoResult

com.matrix.pojo.cache 返回的缓存数据模型。通常用key=json-string的情况下




info.matrix-core.1000.properties
info.matrix-quartz.2000.properties
info.power-api.3000.properties
info.power-cache.4000.properties






info.example-ui.99999.properties

