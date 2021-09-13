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

	@ApiOperation(value = "create ${entityName} Entry", httpMethod = "POST")
	@PostMapping("/createEntry-api")
	public Object createEntryApi(@RequestBody ${entityName} ${entityName?uncap_first}) {
		return ${entityName?uncap_first}Service.createEntryApi(${entityName?uncap_first});
	}

	@ApiOperation(value = "delete ${entityName} Entry", httpMethod = "POST")
	@PostMapping("/deleteEntry-api")
	public Object deleteEntryApi(@RequestBody ${entityName} ${entityName?uncap_first}) {
		return ${entityName?uncap_first}Service.deleteEntryApi(${entityName?uncap_first});
	}

	@ApiOperation(value = "updateEntry ${entityName} Entry", httpMethod = "POST")
	@PostMapping("/updateEntry-api")
	public Object updateEntryApi(@RequestBody ${entityName} ${entityName?uncap_first}) {
		return ${entityName?uncap_first}Service.updateEntryApi(${entityName?uncap_first});
	}

	@ApiOperation(value = "search ${entityName} Entry", httpMethod = "POST")
	@PostMapping("/search-api")
	public Object searchApi(@RequestBody SearchCondition<${entityName}> searchCondition) {
		return ${entityName?uncap_first}Service.searchApi(searchCondition);
	}

	@ApiOperation(value = "searchKeyword ${entityName} Entry", httpMethod = "POST")
	@PostMapping("/searchKeyword-api")
	public Object searchKeywordApi(@RequestBody String keyword) {
		SearchCondition searchCondition = new SearchCondition();
		return ${entityName?uncap_first}Service.searchKeywordApi(searchCondition);
	}

	@Autowired
	private ${entityName}Service ${entityName?uncap_first}Service;

}
