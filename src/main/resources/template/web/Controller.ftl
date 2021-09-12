${copyright}

package ${modulePackage}.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ${modulePackage}.model.${entityName};
import ${modulePackage}.service.${entityName}Service;
import ${modulePackage}.utils.SearchCondition;

/**
 * @author ${authName}
 * @version ${.now?date}
 */

@RestController
@RequestMapping("/echannel/v1/${simpleEntityName}")
@Slf4j
public class ${entityName}Controller {

	@PostMapping("/createEntry-api")
	public Object createEntryApi(@RequestBody ${entityName} ${entityName?uncap_first}) {
		return ${entityName?uncap_first}Service.createEntryAPI(${entityName?uncap_first});
	}

	@PostMapping("/deleteEntry-api")
	public Object deleteEntryApi(@RequestBody ${entityName} ${entityName?uncap_first}) {
		return ${entityName?uncap_first}Service.deleteEntryAPI(${entityName?uncap_first});
	}

	@PostMapping("/updateEntry-api")
	public Object updateEntryApi(@RequestBody ${entityName} ${entityName?uncap_first}) {
		return ${entityName?uncap_first}Service.updateEntryAPI(${entityName?uncap_first});
	}

	@PostMapping("/search-api")
	public Object searchApi(@RequestBody SearchCondition<${entityName}> searchCondition) {
		return ${entityName?uncap_first}Service.searchAPI(searchCondition);
	}

	@PostMapping("/searchKeyword-api")
	public Object searchKeywordApi(@RequestBody String keyword) {
		return ${entityName?uncap_first}Service.searchKeywordAPI(keyword);
	}

	@Autowired
	private ${entityName}Service ${entityName?uncap_first}Service;

}
