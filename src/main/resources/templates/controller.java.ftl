package ${package.Controller};

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass}{
    <#else>
public class ${table.controllerName} {
    </#if>

    private final ${table.serviceName} ${(table.serviceName?substring(1))?uncap_first};

    public ${table.controllerName} (${table.serviceName} ${(table.serviceName?substring(1))?uncap_first}){this.${(table.serviceName?substring(1))?uncap_first} = ${(table.serviceName?substring(1))?uncap_first};}

    @ApiOperation(value = "新增${table.comment!}")
    @PostMapping("/${entity?uncap_first}")
    public boolean save${entity}(@RequestBody ${entity} ${entity?uncap_first}){
    return ${(table.serviceName?substring(1))?uncap_first}.save${entity}(${entity?uncap_first});
    }

    @ApiOperation(value = "删除${table.comment!}")
    @DeleteMapping("/${entity?uncap_first}/{id}")
    public boolean remove${entity}(@PathVariable("id") String id){
    return ${(table.serviceName?substring(1))?uncap_first}.remove${entity}(id);
    }

    @ApiOperation(value = "批量删除${table.comment!}")
    @DeleteMapping("/${entity?uncap_first}s")
    public boolean remove${entity}ByIds(@RequestBody List <String> ids){
        return ${(table.serviceName?substring(1))?uncap_first}.remove${entity}ByIds(ids);
        }


        @ApiOperation(value = "更新${table.comment!}")
        @PutMapping("/${entity?uncap_first}")
        public boolean update${entity}(@RequestBody ${entity} ${entity?uncap_first}){
        return ${(table.serviceName?substring(1))?uncap_first}.update${entity}(${entity?uncap_first});
        }

        @ApiOperation(value = "查询${table.comment!}分页数据")
        @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "分页参数"),
        @ApiImplicitParam(name = "${entity?uncap_first}", value = "查询条件")
        })
        @GetMapping("/${entity?uncap_first}/page")
        public IPage<${entity}> page${entity}(Page<${entity}> page,${entity} ${entity?uncap_first}){
        return ${(table.serviceName?substring(1))?uncap_first}.page${entity}(page, ${entity?uncap_first});
        }

        @ApiOperation(value = "id查询${table.comment!}")
        @GetMapping("/${entity?uncap_first}/{id}")
        public ${entity} get${entity}ById(@PathVariable String id){
        return ${(table.serviceName?substring(1))?uncap_first}.get${entity}ById(id);
        }

        }
</#if>