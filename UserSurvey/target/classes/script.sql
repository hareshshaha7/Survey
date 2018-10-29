CREATE DATABASE [UserSurvey];

Use [UserSurvey]
Go

CREATE TABLE [User] (
    [UserId] INT IDENTITY(1,1) PRIMARY KEY,
    [FirstName] VARCHAR(255),
    [LastName] VARCHAR(255),
	[DisplayName] VARCHAR(255),
	[Email] VARCHAR(255) NOT NULL,
	[Password] VARCHAR(255) NOT NULL,
	[Status] BIT NOT NULL DEFAULT(1),
	[CreatedBy] INT NOT NULL DEFAULT(1),
	[CreatedOn] DATETIME DEFAULT(GETUTCDATE()),
	[ModifiedBy] INT,
	[ModifiedOn] DATETIME
);

CREATE TABLE [QuestionTypeMaster] (
	[QuestionTypeId] INT IDENTITY(1,1) PRIMARY KEY,
	[QuestionType] VARCHAR(255) NOT NULL,
	[QuestionTypeDesc] VARCHAR(255),
	[Status] BIT NOT NULL DEFAULT(1),
	[CreatedBy] INT NOT NULL DEFAULT(1),
	[CreatedOn] DATETIME DEFAULT(GETUTCDATE()),
	[ModifiedBy] INT,
	[ModifiedOn] DATETIME
);

CREATE TABLE [Question] (
	[QuestionId] INT IDENTITY(1,1) PRIMARY KEY,
	[QuestionTypeId] INT NOT NULL,
	[QuestionName] VARCHAR(255) NOT NULL,
	[Status] BIT NOT NULL DEFAULT(1),
	[CreatedBy] INT NOT NULL DEFAULT(1),
	[CreatedOn] DATETIME DEFAULT(GETUTCDATE()),
	[ModifiedBy] INT,
	[ModifiedOn] DATETIME,
	FOREIGN KEY ([QuestionTypeId]) REFERENCES [QuestionTypeMaster]([QuestionTypeId])
);

CREATE TABLE [Answer] (
	[AnswerId] INT IDENTITY(1,1) PRIMARY KEY,
	[QuestionId] INT NOT NULL,
	[Answer] VARCHAR(255) NOT NULL,
	[AnsweredBy] INT NOT NULL,
	[PostedOn] DATETIME DEFAULT(GETUTCDATE()),
	[Status] BIT NOT NULL DEFAULT(1),
	[CreatedBy] INT NOT NULL DEFAULT(1),
	[CreatedOn] DATETIME DEFAULT(GETUTCDATE()),
	[ModifiedBy] INT,
	[ModifiedOn] DATETIME,
	FOREIGN KEY ([QuestionId]) REFERENCES [Question]([QuestionId]),
	FOREIGN KEY ([AnsweredBy]) REFERENCES [User]([UserId])
);