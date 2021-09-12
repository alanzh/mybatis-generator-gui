${copyright}

package ${modulePackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${modulePackage}.mapper.${entityName}Mapper;
import ${modulePackage}.service.${entityName}Service;

/**
 * @author ${authName}
 * @version ${.now?date}
 */
 
@Service
public class ${entityName}ServiceImpl implements ${entityName}Service{

	@Autowired
	private ${entityName}Mapper ${entityName?uncap_first}Mapper;

}
