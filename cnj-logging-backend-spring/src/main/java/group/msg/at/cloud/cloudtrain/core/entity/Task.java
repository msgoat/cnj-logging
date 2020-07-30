package group.msg.at.cloud.cloudtrain.core.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * {@code Entity} type that represents tasks.
 *
 * @author Michael Theis (mtheis@msg.group)
 * @version 1.0
 * @since release 1.0 29.10.2012 17:27:22
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "T_TASK")
public class Task {

    /**
     * Unique identifier of this task.
     * <p>
     * <strong>Note:</strong> Spring data is even capable of handling autogeneration of UUID typed IDs, so no need
     * for a setter.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASK_ID")
    private UUID id;

    /**
     * Single-line description or summary of what this task is about.
     */
    @Size(max = 80)
    @Column(name = "SUBJECT")
    private String subject;

    /**
     * Detailed description of this task.
     */
    @Size(max = 1024)
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Groups task into specific categories like "Bug", "Enhancement".
     */
    @NotNull
    @Column(name = "CATEGORY")
    @Enumerated(EnumType.ORDINAL)
    private TaskCategory category = TaskCategory.UNDEFINED;

    /**
     * Priority.
     */
    @NotNull
    @Column(name = "PRIORITY")
    @Enumerated(EnumType.ORDINAL)
    private TaskPriority priority = TaskPriority.UNDEFINED;

    /**
     * Status of this task.
     */
    @NotNull
    @Column(name = "LIFECYCLE_STATE")
    @Enumerated(EnumType.ORDINAL)
    private TaskLifeCycleState lifeCycleState = TaskLifeCycleState.UNDEFINED;

    /**
     * Date/time when this task has been requested.
     * <p>
     * Expected to be set when task lifeCycleState is <code>running</code>.
     * </p>
     */
    @Column(name = "SUBMISSION_DATE")
    private LocalDateTime submittedAt;

    /**
     * User-ID of participant who submitted this task.
     * <p>
     * Expected to be set when task lifeCycleState is <code>completed</code>.
     * </p>
     */
    @Column(name = "SUBMITTER_USER_ID")
    private String submitterUserId;

    /**
     * Date/time when this task is supposed to be completed.
     */
    @Column(name = "DUE_DATE")
    private LocalDateTime dueDate;

    /**
     * Completion rate in percent, ranges from 0 to 100.
     */
    @Column(name = "COMPLETION_RATE")
    private int completionRate;

    /**
     * Date/time when this task has been completed.
     * <p>
     * Expected to be set when task lifeCycleState is <code>completed</code>.
     * </p>
     */
    @Column(name = "COMPLETION_DATE")
    private LocalDateTime completionDate;

    /**
     * User-ID of participant who completed this task.
     * <p>
     * Expected to be set when task lifeCycleState is <code>completed</code>.
     * </p>
     */
    @Column(name = "COMPLETER_USER_ID")
    private String completedByUserId;

    /**
     * User-ID of participant who is currently responsible for the completion of
     * this task.
     */
    @Size(max = 16)
    @Column(name = "RESPONSIBLE_USER_ID")
    private String responsibleUserId;

    /**
     * Project-ID of the project this task is related to.
     * <p>
     * Equals {@link #affectedApplicationId} if this is a application maintenance
     * task not related to a specific project.
     * </p>
     */
    @Size(max = 32)
    @Column(name = "AFFECTED_PROJECT_ID")
    private String affectedProjectId;

    /**
     * Application-ID of the application this task is related to.
     */
    @Size(max = 32)
    @Column(name = "AFFECTED_APPLICATION_ID")
    private String affectedApplicationId;

    /**
     * Name of the logical module this task is related to.
     */
    @Size(max = 32)
    @Column(name = "AFFECTED_MODULE")
    private String affectedModule;

    /**
     * Application resource that this task is referring to.
     */
    @Size(max = 256)
    @Column(name = "AFFECTED_RESOURCE")
    private String affectedResource;

    /**
     * Estimated effort in hours to complete this task.
     */
    @Column(name = "ESTIMATED_EFFORT")
    private int estimatedEffort;

    /**
     * Actual effort in hours to complete this task.
     */
    @Column(name = "ACTUAL_EFFORT")
    private int actualEffort;

    /**
     * Current version of this instance (used for optimistic locking).
     */
    @Column(name = "OPT_LOCK_VERSION")
    @Version
    private long version;

    @CreatedBy
    @Size(max = 31)
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Size(max = 31)
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_AT")
    private LocalDateTime lastModifiedAt;

    public Task() {

    }

    public UUID getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskCategory getCategory() {
        return category;
    }

    public void setCategory(TaskCategory category) {
        this.category = category;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public TaskLifeCycleState getLifeCycleState() {
        return lifeCycleState;
    }

    public void setLifeCycleState(TaskLifeCycleState state) {
        this.lifeCycleState = state;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime startDate) {
        this.submittedAt = startDate;
    }

    public String getSubmitterUserId() {
        return submitterUserId;
    }

    public void setSubmitterUserId(String requesterUserId) {
        this.submitterUserId = requesterUserId;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public int getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(int completionRate) {
        this.completionRate = completionRate;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }

    public String getCompletedByUserId() {
        return completedByUserId;
    }

    public void setCompletedByUserId(String completedById) {
        this.completedByUserId = completedById;
    }

    public String getResponsibleUserId() {
        return responsibleUserId;
    }

    public void setResponsibleUserId(String responsibleId) {
        this.responsibleUserId = responsibleId;
    }

    public String getAffectedProjectId() {
        return affectedProjectId;
    }

    public void setAffectedProjectId(String affectedProjectId) {
        this.affectedProjectId = affectedProjectId;
    }

    public String getAffectedApplicationId() {
        return affectedApplicationId;
    }

    public void setAffectedApplicationId(String affectedApplicationId) {
        this.affectedApplicationId = affectedApplicationId;
    }

    public String getAffectedModule() {
        return affectedModule;
    }

    public void setAffectedModule(String affectedModule) {
        this.affectedModule = affectedModule;
    }

    public String getAffectedResource() {
        return affectedResource;
    }

    public void setAffectedResource(String affectedResource) {
        this.affectedResource = affectedResource;
    }

    public int getEstimatedEffort() {
        return estimatedEffort;
    }

    public void setEstimatedEffort(int estimatedEffort) {
        this.estimatedEffort = estimatedEffort;
    }

    public int getActualEffort() {
        return actualEffort;
    }

    public void setActualEffort(int actualEffort) {
        this.actualEffort = actualEffort;
    }

    public long getVersion() {
        return version;
    }

    /**
     * Returns the user ID of the user that created this entity.
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Returns the creation date and time of this entity.
     */
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Returns the user ID of the user that modified this entity the last time.
     */
    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    /**
     * Returns the date and time of the last modification of this entity.
     */
    public LocalDateTime getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 7;
        result = prime * result + this.id.hashCode();
        return result;
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " { id : " + this.id + ", version : " + this.version + " }";
    }
}
