package com.atlan.model.workflow;

import com.atlan.model.core.AtlanObject;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Jacksonized
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class WorkflowSpec extends AtlanObject {
    private static final long serialVersionUID = 2L;

    List<WorkflowTemplate> templates;
    String entrypoint;
    final Object arguments;
}
