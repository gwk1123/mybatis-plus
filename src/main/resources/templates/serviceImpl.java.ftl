package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;
import org.springframework.util.CollectionUtils;


/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public  IPage<${entity}> page${entity}(Page<${entity}> page,${entity} ${entity?uncap_first}){

        page = Optional.ofNullable(page).orElse(new Page<>());
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();

        return  this.page(page, queryWrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save${entity}(${entity} ${entity?uncap_first}){
        Assert.notNull(${entity?uncap_first}, "${table.comment!}为空");
        return this.save(${entity?uncap_first});
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove${entity}(String id){
        Assert.hasText(id, "主键为空");
        return this.removeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean remove${entity}ByIds(List<String> ids){
        Assert.isTrue(!CollectionUtils.isEmpty(ids), "主键集合为空");
        return this.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update${entity}(${entity} ${entity?uncap_first}){
        Assert.notNull(${entity?uncap_first}, "${table.comment!}为空");
        return this.updateById(${entity?uncap_first});
    }

    @Override
    public ${entity} get${entity}ById(String id){
        return  this.getById(id);
    }
}
</#if>
