package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page      分页参数
     * @param ${entity?uncap_first} 查询条件
     * @return IPage<${entity}>
     */
     IPage<${entity}> page${entity}(Page<${entity}> page,${entity} ${entity?uncap_first});

    /**
     * 新增${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return boolean
     */
    boolean save${entity}(${entity} ${entity?uncap_first});

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     * @return boolean
     */
    boolean remove${entity}(String id);

    /**
     * 批量删除${table.comment!}
     *
     * @param ids 主键集合
     * @return boolean
     */
    boolean remove${entity}ByIds(List<String> ids);

    /**
     * 修改${table.comment!}
     *
     * @param ${entity?uncap_first} ${table.comment!}
     * @return boolean
     */
    boolean update${entity}(${entity} ${entity?uncap_first});

    /**
     * id查询数据
     *
     * @param id id
     * @return ${entity}
     */
    ${entity} get${entity}ById(String id);
}
</#if>
