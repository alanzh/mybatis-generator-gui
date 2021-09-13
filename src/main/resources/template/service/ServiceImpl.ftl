${copyright}

package ${modulePackage}.service.impl;

import ${modulePackage}.dao.${entityName}Mapper;
import ${modulePackage}.service.${entityName}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ${authName}
 * @version ${.now?date}
 */

@Service
public class ${entityName}ServiceImpl implements ${entityName}Service{

	@Autowired
	private ${entityName}Mapper ${entityName?uncap_first}Mapper;

    @Override
    public Object createEntryApi(${entityName} entry) {
        return null;
    }

    @Override
    public Object deleteEntryApi(${entityName} entry) {
        return null;
    }

    @Override
    public Object updateEntryApi(${entityName} entry) {
        return null;
    }

    @Override
    public Object searchApi(SearchCondition<${entityName}> searchCondition) {
        return null;
    }

    @Override
    public Object searchKeywordApi(SearchCondition<${entityName}> searchCondition) {
        return null;
    }
}
