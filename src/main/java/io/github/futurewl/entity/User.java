package io.github.futurewl.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.UnknownTypeHandler;

@Data
@TableName(value = "sys_user", // String 表名注解，标识实体类对应的表
        schema = "db_mybatis_plus_samples", // String schema
        keepGlobalPrefix = true, // boolean 是否保持使用全局的 tablePrefix 的值（当全局 tablePrefix 生效时）
        resultMap = "", // String xml 中 resultMap 的 id（用于满足特定类型的实体类对象绑定）
        autoResultMap = true, // 是否自动构建 resultMap 并使用（如果设置 resultMap 则不会进行 resultMap 的自动构建与注入）
        excludeProperty = {""} // 需要排除的属性名 @since 3.3.1
)
@KeySequence() // oracle
@InterceptorIgnore // see 插件主体
public class User {
    @TableId(value = "", // 主键字段名
            /*
                #IdType
                值	描述
                AUTO	数据库 ID 自增
                NONE	无状态，该类型为未设置主键类型（注解里等于跟随全局，全局里约等于 INPUT）
                INPUT	insert 前自行 set 主键值
                ASSIGN_ID	分配 ID(主键类型为 Number(Long 和 Integer)或 String)(since 3.3.0),使用接口IdentifierGenerator的方法nextId(默认实现类为DefaultIdentifierGenerator雪花算法)
                ASSIGN_UUID	分配 UUID,主键类型为 String(since 3.3.0),使用接口IdentifierGenerator的方法nextUUID(默认 default 方法)
             */
            type = IdType.AUTO // Enum IdType.NONE	指定主键类型
    )
    private Long id;
    @TableField( // 描述：字段注解（非主键）
            value = "", // 数据库字段名
            exist = true,// 是否为数据库表字段
            condition = "",// 字段 where 实体查询比较条件，有值设置则按设置的值为准，没有则为默认全局的 %s=#{%s}，参考
            update = "", // 字段 update set 部分注入，例如：当在version字段上注解update="%s+1" 表示更新时会 set version=version+1 （该属性优先级高于 el 属性）
            insertStrategy = FieldStrategy.DEFAULT, // 举例：NOT_NULL insert into table_a(<if test="columnProperty != null">column</if>) values (<if test="columnProperty != null">#{columnProperty}</if>)
            updateStrategy = FieldStrategy.DEFAULT, // 举例：IGNORED update table_a set column=#{columnProperty}
            whereStrategy = FieldStrategy.DEFAULT, // 举例：NOT_EMPTY where <if test="columnProperty != null and columnProperty!=''">column=#{columnProperty}</if>
            fill = FieldFill.DEFAULT, // 字段自动填充策略
            select = true, // 是否进行 select 查询
            keepGlobalFormat = false,// 是否保持使用全局的 format 进行处理
            jdbcType = JdbcType.UNDEFINED, // JDBC 类型 (该默认值不代表会按照该值生效)
            typeHandler = UnknownTypeHandler.class, // 类型处理器 (该默认值不代表会按照该值生效)
            numericScale = "" // 指定小数点后保留的位数
    )
    @Version // 描述：乐观锁注解、标记 @Verison 在字段上
    @EnumValue // 描述：普通枚举类注解(注解在枚举字段上)
    @TableLogic // 描述：表字段逻辑处理注解（逻辑删除）
    private String name;
    @OrderBy() // 描述：内置 SQL 默认指定排序，优先级低于 wrapper 条件查询
    private Integer age;
    private String email;
}
