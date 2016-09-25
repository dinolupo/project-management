create index IX_5E372214 on PM_Entry (groupId);
create index IX_4393AA95 on PM_Entry (name);
create index IX_A96CD8BC on PM_Entry (projectId, groupId);
create index IX_C316299E on PM_Entry (uuid_);
create index IX_A3C44BCA on PM_Entry (uuid_, companyId);
create unique index IX_80A13CCC on PM_Entry (uuid_, groupId);

create index IX_EF655C16 on PM_Foo (field2);
create index IX_DB0E844A on PM_Foo (uuid_);
create index IX_4ACD9E on PM_Foo (uuid_, companyId);
create unique index IX_D2C623A0 on PM_Foo (uuid_, groupId);

create index IX_8F5A808D on PM_Project (groupId);
create index IX_108486BC on PM_Project (name);
create index IX_BDA6C16E on PM_Project (name, groupId);
create index IX_9440D257 on PM_Project (uuid_);
create index IX_78412571 on PM_Project (uuid_, companyId);
create unique index IX_1A065433 on PM_Project (uuid_, groupId);