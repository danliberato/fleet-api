package com.example.fleetapi.domain.exceptions;

import lombok.Getter;

@Getter
public class DomainException extends RuntimeException {

  private final Issue issue;

  public DomainException(final Issue issue) {
    super(issue.getMessage());
    this.issue = issue;
  }

  public DomainException(final Issue issue, final Throwable cause) {
    super(issue.getMessage(), cause);
    this.issue = issue;
  }

}
